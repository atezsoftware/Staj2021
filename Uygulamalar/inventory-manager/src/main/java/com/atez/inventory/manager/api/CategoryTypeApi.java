package com.atez.inventory.manager.api;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atez.inventory.manager.dto.CategoryTypeDTO;
import com.atez.inventory.manager.entity.CategoryTypeEntity;

@RequestMapping(path = "/v1/api/categoryTypes")
public interface CategoryTypeApi {
	
	@PostMapping
	public CategoryTypeEntity save(@RequestBody @Validated CategoryTypeDTO categoryTypeDTO);

	@GetMapping
	public List<CategoryTypeEntity> get();
	

}
