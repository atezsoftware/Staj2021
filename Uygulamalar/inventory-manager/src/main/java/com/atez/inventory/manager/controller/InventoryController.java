package com.atez.inventory.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.InventoryApi;
import com.atez.inventory.manager.dto.InventoryDTO;
import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.service.InventoryService;

@RestController
public class InventoryController implements InventoryApi {
	
	
	@Autowired
	private InventoryService inventoryService;
	
	

	@Override
	public InventoryEntity save(InventoryDTO iventoryDTO) {
		return inventoryService.save(iventoryDTO);
	}

	
	@Override
	public Page<InventoryEntity> get(int page, int size,String sortBy) {
		Pageable pageable =  PageRequest.of(page, size, Sort.by(sortBy).descending());
		return inventoryService.pagination(pageable);
	}


	@Override
	public InventoryEntity update(InventoryDTO iventoryDTO) {
		return inventoryService.update(iventoryDTO);
	}


	@Override
	public Boolean delete(String id) {
		return inventoryService.delete(id);
	}
}
