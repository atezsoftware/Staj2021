package com.atez.inventory.manager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.atez.inventory.manager.entity.base.BaseEntity;

@Entity
@Table(name = "INVENTORY")
public class InventoryEntity extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2209929968844114258L;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SERAIL_NUMBER")
	private String serialNumber;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryTypeEntity categoryType;
	
	@OneToMany(mappedBy = "inventory" ,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<InventoryDetailEntity> inventoryDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CategoryTypeEntity getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryTypeEntity categoryType) {
		this.categoryType = categoryType;
	}

	public List<InventoryDetailEntity> getInventoryDetails() {
		return inventoryDetails;
	}

	public void setInventoryDetails(List<InventoryDetailEntity> inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}


}
