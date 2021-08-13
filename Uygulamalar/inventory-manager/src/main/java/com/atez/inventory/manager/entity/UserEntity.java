package com.atez.inventory.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.atez.inventory.manager.entity.base.BaseEntity;

@Entity
@Table(name = "USERS")
public class UserEntity  extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "KEYCLOAK_ID")
	private String keyCloakId;
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LAST_NAME")
	private String lastname;

	
	public String getKeyCloakId() {
		return keyCloakId;
	}

	public void setKeyCloakId(String keyCloakId) {
		this.keyCloakId = keyCloakId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	

}
