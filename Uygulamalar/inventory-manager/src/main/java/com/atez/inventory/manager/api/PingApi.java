package com.atez.inventory.manager.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/v1/api/ping")
public interface PingApi {
	
	@GetMapping
	public String ping();

}
