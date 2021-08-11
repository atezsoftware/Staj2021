package com.atez.inventory.manager.entity.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@CreationTimestamp
	@Column(name = "CDATE")
	private LocalDateTime cdate;
	
	@UpdateTimestamp
	@Column(name = "UDATE")
	private LocalDateTime udate;
	
	@Column(name = "UUSERID")
	private String uuserId;
	
	@Column(name = "CUSERID")
	private String cuserId;


	public LocalDateTime getCdate() {
		return cdate;
	}

	public void setCdate(LocalDateTime cdate) {
		this.cdate = cdate;
	}

	public LocalDateTime getUdate() {
		return udate;
	}

	public void setUdate(LocalDateTime udate) {
		this.udate = udate;
	}

	public String getUuserId() {
		return uuserId;
	}

	public void setUuserId(String uuserId) {
		this.uuserId = uuserId;
	}

	public String getCuserId() {
		return cuserId;
	}

	public void setCuserId(String cuserId) {
		this.cuserId = cuserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
