package com.atez.inventory.manager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.AuthApi;
import com.atez.inventory.manager.dto.AuthResponse;
import com.atez.inventory.manager.dto.LoginDTO;
import com.atez.inventory.manager.service.KeyCloakService;

@RestController
public class AuthController  implements AuthApi{
	
	@Autowired
	private KeyCloakService keyCloakService;

	@Override
	public AuthResponse login(@Valid LoginDTO login) {
		return keyCloakService.login(login.getUsername(),login.getUsername());
	}

}
