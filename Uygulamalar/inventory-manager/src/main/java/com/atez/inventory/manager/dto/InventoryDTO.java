package com.atez.inventory.manager.dto;

import java.io.Serializable;

public class InventoryDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2330660858233427652L;

	private String id;
	
	private String name;
	
	private String serialNumber;
	
	private String categoryTypeId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCategoryTypeId() {
		return categoryTypeId;
	}

	public void setCategoryTypeId(String categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}
}
