package com.atez.inventory.manager.util;
import java.util.Objects;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.atez.inventory.manager.domain.KeycloakUser;


@Component
public class KeycloakSecurityClient {

    public KeycloakUser getCurrentUser()  {
        KeycloakUser keycloakUser = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (Objects.nonNull(securityContext) && Objects.nonNull(securityContext.getAuthentication()) && securityContext.getAuthentication() instanceof KeycloakAuthenticationToken) {
            KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) securityContext.getAuthentication();
            AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
            if (Objects.nonNull(accessToken)) {
                keycloakUser = new KeycloakUser();
                keycloakUser.setId(accessToken.getSubject());
                keycloakUser.setPreferred_username(accessToken.getPreferredUsername());
                keycloakUser.setFirstName(accessToken.getGivenName());
                keycloakUser.setLastName(accessToken.getFamilyName());
                keycloakUser.setPhone(accessToken.getPhoneNumber());
                if (Objects.nonNull(accessToken.getOtherClaims()) && !accessToken.getOtherClaims().isEmpty()) {
                   
                   // keycloakUser.setUserId((String) accessToken.getOtherClaims().get(USER_ID));
                }
            }
        }
        return keycloakUser;
    }
}
