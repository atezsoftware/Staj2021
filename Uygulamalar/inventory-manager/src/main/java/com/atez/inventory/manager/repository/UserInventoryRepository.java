package com.atez.inventory.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atez.inventory.manager.entity.UserInventoryEntity;

public interface UserInventoryRepository extends JpaRepository<UserInventoryEntity, String>{

	Optional<UserInventoryEntity> findByUserIdAndInventoryId(String userId,String inventoryId);
	
}
