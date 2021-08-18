package com.atez.inventory.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.atez.inventory.manager.entity.base.BaseEntity;

@Entity
@Table(name = "USER_INVENTORY")
public class UserInventoryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2209929968844114258L;

	@ManyToOne
	@JoinColumn(name = "INVENTORY_ID")
	private InventoryEntity inventory;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@Column(name = "STATUS")
	private String status;

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
