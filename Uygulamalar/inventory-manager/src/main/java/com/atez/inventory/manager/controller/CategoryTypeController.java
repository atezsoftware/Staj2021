package com.atez.inventory.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atez.inventory.manager.api.CategoryTypeApi;
import com.atez.inventory.manager.dto.CategoryTypeDTO;
import com.atez.inventory.manager.entity.CategoryTypeEntity;
import com.atez.inventory.manager.service.CategoryTypeService;

@RestController
public class CategoryTypeController implements CategoryTypeApi {

	@Autowired
	private CategoryTypeService categoryTypeService;
	
	@Override
	public CategoryTypeEntity save(CategoryTypeDTO categoryTypeDTO) {
		return categoryTypeService.save(categoryTypeDTO);
	}

	@Override
	public List<CategoryTypeEntity> get() {
		return categoryTypeService.findAll();
	}

}
