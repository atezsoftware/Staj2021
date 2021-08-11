package com.atez.inventory.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atez.inventory.manager.entity.CategoryTypeEntity;

public interface CategoryTypeRepository extends JpaRepository<CategoryTypeEntity, String> {

}
