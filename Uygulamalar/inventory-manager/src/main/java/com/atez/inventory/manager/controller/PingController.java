package com.atez.inventory.manager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.PingApi;

@RestController
public class PingController implements PingApi {

	@Override
	public String ping() {
		return "Do not worry, I am alive";
	}

}
