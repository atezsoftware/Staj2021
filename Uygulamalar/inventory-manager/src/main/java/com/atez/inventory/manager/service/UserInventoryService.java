package com.atez.inventory.manager.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atez.inventory.manager.dto.UserInventoryDTO;
import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;
import com.atez.inventory.manager.repository.UserInventoryRepository;

@Service
public class UserInventoryService {

	@Autowired
	private UserInventoryRepository userInventoryRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private InventoryService inventoryService;

	public UserInventoryEntity save(@Valid UserInventoryDTO userInventoryDTO) {
		InventoryEntity inventory = inventoryService.findById(userInventoryDTO.getInventoryId());
		UserEntity user = userService.findByUsernameFromKeycloak(userInventoryDTO.getUserId());
		
		Optional<UserInventoryEntity> userInventoryOpt = userInventoryRepository.findByUserIdAndInventoryId(user.getId(), userInventoryDTO.getInventoryId());
		if(userInventoryOpt.isPresent()) {
			throw new CustomException(ErrorCodes.INVENTORY_ALREADY_ASSINGED);
		}
		
		UserInventoryEntity userIveInventoryEntity=new UserInventoryEntity();
		userIveInventoryEntity.setInventory(inventory);
		userIveInventoryEntity.setUser(user);
		userIveInventoryEntity.setStatus("ACTIVE");
		
		return save(userIveInventoryEntity);
	}
	
	
	public UserInventoryEntity save(@Valid UserInventoryEntity userInventoryEntity) {
		return userInventoryRepository.save(userInventoryEntity);
	}

	public List<UserInventoryEntity> findAll() {
		return userInventoryRepository.findAll();
	}

	public UserInventoryEntity findById(String id) {
		return userInventoryRepository.findById(id).orElse(null);
	}
	
	

}
