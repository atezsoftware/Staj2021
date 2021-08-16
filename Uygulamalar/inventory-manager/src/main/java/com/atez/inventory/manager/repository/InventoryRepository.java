package com.atez.inventory.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atez.inventory.manager.entity.InventoryEntity;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String>{
    Optional<InventoryEntity> findInventoryEntityById(String id);

}
