package com.atez.inventory.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atez.inventory.manager.dto.InventoryDTO;
import com.atez.inventory.manager.entity.CategoryTypeEntity;
import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;
import com.atez.inventory.manager.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private CategoryTypeService categoryTypeService;

	public List<InventoryEntity> findAll() {
		return inventoryRepository.findAll();
	}
	

	public InventoryEntity save(InventoryDTO iventoryDTO)  {
		CategoryTypeEntity categoryTypeOpt = categoryTypeService.findById(iventoryDTO.getCategoryTypeId());
	
		
		InventoryEntity entity = new InventoryEntity();
		entity.setCategoryType(categoryTypeOpt);
		entity.setName(iventoryDTO.getName());

		entity.setSerialNumber(iventoryDTO.getSerialNumber());
		entity.setStatus("ACTIVE");
		return inventoryRepository.save(entity);
	}
	
	
	public InventoryEntity update(InventoryDTO iventoryDTO) {
		InventoryEntity inventory = findById(iventoryDTO.getId());
		
		
		inventory.setName(iventoryDTO.getName());
		inventory.setSerialNumber(iventoryDTO.getSerialNumber());
		
		CategoryTypeEntity categoryTypeOpt = categoryTypeService.findById(iventoryDTO.getCategoryTypeId());
		inventory.setCategoryType(categoryTypeOpt);
		
		return inventoryRepository.save(inventory);
		
	}

	public Page<InventoryEntity> pagination(Pageable pageable) {
		return inventoryRepository.findAll(pageable);
	}

	public InventoryEntity findById(String id) {
		Optional<InventoryEntity> inventoryOpt = inventoryRepository.findById(id);
	
		if(inventoryOpt.isEmpty()) {
			throw new CustomException(ErrorCodes.COULD_NOT_FOUND_INVENTORY);
		}
		
		return inventoryOpt.get();
	}


	public Boolean delete(String id) {
		Optional<InventoryEntity> inventoryOpt = inventoryRepository.findById(id);
		if(inventoryOpt.isEmpty()) {
			return Boolean.FALSE;
		}
		inventoryRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
