package com.atez.inventory.manager.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atez.inventory.manager.domain.KeycloakUser;

@RequestMapping(path = "/v1/api/users")
public interface UserApi {
	
	@GetMapping
	public List<KeycloakUser> get();
}
