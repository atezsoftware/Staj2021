package com.atez.inventory.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atez.inventory.manager.dto.CategoryTypeDTO;
import com.atez.inventory.manager.entity.CategoryTypeEntity;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;
import com.atez.inventory.manager.repository.CategoryTypeRepository;

@Service
public class CategoryTypeService {

	@Autowired
	private CategoryTypeRepository categoryTypeRepository;

	public CategoryTypeEntity save(CategoryTypeDTO categoryType) {
		CategoryTypeEntity entity = new CategoryTypeEntity();
		entity.setName(categoryType.getName());
		return categoryTypeRepository.save(entity);

	}

	public List<CategoryTypeEntity> findAll() {
		return categoryTypeRepository.findAll();
	}

	public CategoryTypeEntity findById(String categoryTypeId) {
		Optional<CategoryTypeEntity> categoryTypeOpt = categoryTypeRepository.findById(categoryTypeId);
		if (categoryTypeOpt.isEmpty()) {
			throw new CustomException(ErrorCodes.COULD_NOT_FOUND_CATEGORY_TYPE);
		}
		return categoryTypeOpt.get();
	}

}
