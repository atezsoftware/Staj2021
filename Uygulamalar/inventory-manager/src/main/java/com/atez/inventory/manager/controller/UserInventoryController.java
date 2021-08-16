package com.atez.inventory.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.atez.inventory.manager.dto.UserInventoryHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.UserInventoryApi;
import com.atez.inventory.manager.dto.UserInventoryDTO;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import com.atez.inventory.manager.service.UserInventoryService;

@RestController
public class UserInventoryController implements UserInventoryApi {
	
	
	@Autowired
	private UserInventoryService userInventoryService;

	@Override
	public UserInventoryEntity save(@Valid UserInventoryDTO userInventoryDTO) {
		return userInventoryService.save(userInventoryDTO);
	}

	@Override
	public List<UserInventoryEntity> get() {
		
		return userInventoryService.findAll();
	}

	@Override
	public UserInventoryEntity updateStatus(String id, String status) {
		UserInventoryEntity userInv = userInventoryService.findById(id);
		if(userInv!=null) {
			userInv.setStatus(status);
			userInventoryService.save(userInv);
		}
		return userInv;
	}

	@Override
	public UserInventoryHistoryDTO userInventoryHistory(String id) {
		return userInventoryService.findUserInventoryHistory(id);
	}


}
