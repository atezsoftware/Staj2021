package com.atez.inventory.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.UserApi;
import com.atez.inventory.manager.domain.KeycloakUser;
import com.atez.inventory.manager.service.KeyCloakService;


@RestController
public class UserController implements UserApi {

	@Autowired
	private KeyCloakService keyCloakService;
	
	@Override
	public List<KeycloakUser> get() {
		return keyCloakService.getUsers();
	}

}
