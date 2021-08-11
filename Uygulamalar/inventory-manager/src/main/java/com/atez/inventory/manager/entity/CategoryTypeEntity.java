package com.atez.inventory.manager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.atez.inventory.manager.entity.base.BaseEntity;


@Entity
@Table(name = "CATEGORY_TYPE")
public class CategoryTypeEntity  extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7645737024533299167L;
	/**
	 * 
	 */
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "categoryType",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<InventoryEntity> inventory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
