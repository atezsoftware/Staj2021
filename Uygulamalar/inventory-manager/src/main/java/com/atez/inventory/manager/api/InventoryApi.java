package com.atez.inventory.manager.api;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atez.inventory.manager.dto.InventoryDTO;
import com.atez.inventory.manager.entity.InventoryEntity;

@RequestMapping(path = "/v1/api/invertories")
public interface InventoryApi {
	
	@PostMapping
	public InventoryEntity save(@RequestBody @Validated InventoryDTO iventoryDTO);
	
	@GetMapping
	public Page<InventoryEntity> get(int page, int size,String sortBy);
	
	@PutMapping
	public InventoryEntity update(@RequestBody @Validated InventoryDTO iventoryDTO);
	
	
	@DeleteMapping("{id}")
	public Boolean delete(@PathVariable("id") String id);
	
	
	

}
