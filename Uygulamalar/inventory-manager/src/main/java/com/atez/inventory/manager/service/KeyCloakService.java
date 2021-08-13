package com.atez.inventory.manager.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.atez.inventory.manager.config.InvertoryManagerConfig;
import com.atez.inventory.manager.domain.KeycloakUser;
import com.atez.inventory.manager.dto.AuthResponse;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;

@Service
public class KeyCloakService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private InvertoryManagerConfig config;

	public AuthResponse login(String username, String password) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("grant_type", "password");
			map.add("client_id", config.getClientId());
			map.add("client_secret", config.getClientSecret());
			map.add("username", username);
			map.add("password", password);
			map.add("scope", "openid");

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
			ResponseEntity<AuthResponse> response = restTemplate.postForEntity(config.getUrl() + "/realms/inventory/protocol/openid-connect/token", request, AuthResponse.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				throw new CustomException(ErrorCodes.AUTHENTICATION_FAILED);
			} else {
				throw new CustomException(ErrorCodes.SYSTEM_FAILURE, e);
			}
		}
	}
	
	
	
	  public AuthResponse getAccountServiceToken() {
	        try {
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
	    		map.add("client_id", config.getClientId());
				map.add("client_secret", config.getClientSecret());
	            map.add("grant_type", "client_credentials");
	            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
	            ResponseEntity<AuthResponse> response = restTemplate.postForEntity(config.getUrl() + "/realms/inventory/protocol/openid-connect/token", request, AuthResponse.class);

	            return response.getBody();
	        } catch (HttpClientErrorException exception) {
	            throw new CustomException(ErrorCodes.SYSTEM_FAILURE, exception);
	        }
	    }

	    @SuppressWarnings({"rawtypes", "unchecked"})
	    public List<KeycloakUser> getUsers() {
	        try {
	            AuthResponse token = getAccountServiceToken();
	            HttpHeaders userHeaders = new HttpHeaders();
	            userHeaders.setContentType(MediaType.APPLICATION_JSON);
	            userHeaders.add("Authorization", "Bearer" + " " + token.getAccess_token());

	            HttpEntity entity = new HttpEntity(userHeaders);
	            ResponseEntity<KeycloakUser[]> users = restTemplate.exchange(config.getUrl() + "/admin/realms/inventory/users", HttpMethod.GET, entity, KeycloakUser[].class);

	            return Arrays.asList(users.getBody());
	        } catch (HttpClientErrorException exception) {
	            throw new CustomException(ErrorCodes.SYSTEM_FAILURE, exception);
	        }
	    }

}
