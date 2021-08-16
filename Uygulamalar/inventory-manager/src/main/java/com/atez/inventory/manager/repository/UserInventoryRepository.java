package com.atez.inventory.manager.repository;

import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInventoryRepository extends JpaRepository<UserInventoryEntity, String>{

	Optional<UserInventoryEntity> findByUserIdAndInventoryId(String userId,String inventoryId);
	List<UserInventoryEntity> findAllByUser(UserEntity userId);

}
