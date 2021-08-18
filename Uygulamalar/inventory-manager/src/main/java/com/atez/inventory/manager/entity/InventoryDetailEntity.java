package com.atez.inventory.manager.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.atez.inventory.manager.entity.base.BaseEntity;

@Entity
@Table(name = "INVENTORY_DETAIL")
public class InventoryDetailEntity  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9152894840778310980L;
	
	
	@Column(name = "GUARANTEE_START_DATE")
	private LocalDateTime guaranteeStartDate;
	

	@Column(name = "GUARANTEE_END_DATE")
	private LocalDateTime guaranteeEndDate;
	
	@ManyToOne
	@JoinColumn(name = "INVENTORY_ID")
	private InventoryEntity inventory;


	public LocalDateTime getGuaranteeStartDate() {
		return guaranteeStartDate;
	}


	public void setGuaranteeStartDate(LocalDateTime guaranteeStartDate) {
		this.guaranteeStartDate = guaranteeStartDate;
	}


	public LocalDateTime getGuaranteeEndDate() {
		return guaranteeEndDate;
	}


	public void setGuaranteeEndDate(LocalDateTime guaranteeEndDate) {
		this.guaranteeEndDate = guaranteeEndDate;
	}

}
