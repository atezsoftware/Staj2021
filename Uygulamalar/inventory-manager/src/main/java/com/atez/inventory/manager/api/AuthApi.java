package com.atez.inventory.manager.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atez.inventory.manager.dto.AuthResponse;
import com.atez.inventory.manager.dto.LoginDTO;



@RequestMapping(path = "/v1/api/auth")
public interface AuthApi {
	
	
	@PostMapping
	public AuthResponse login(@RequestBody @Valid LoginDTO login);

}
