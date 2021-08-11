package com.atez.inventory.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atez.inventory.manager.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String>{

}
