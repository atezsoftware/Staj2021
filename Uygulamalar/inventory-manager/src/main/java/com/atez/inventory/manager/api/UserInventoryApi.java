package com.atez.inventory.manager.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atez.inventory.manager.dto.UserInventoryDTO;
import com.atez.inventory.manager.entity.UserInventoryEntity;



@RequestMapping(path = "/v1/api/user-inventories")
public interface UserInventoryApi {
	
	@PostMapping
	public UserInventoryEntity save(@RequestBody @Valid UserInventoryDTO login);
	
	@GetMapping
	public List<UserInventoryEntity> get();
	
	@PatchMapping("{id}")
	public UserInventoryEntity updateStatus(@PathVariable("id")String id, @RequestBody @Valid String status);

}
