package com.atez.inventory.manager.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String access_token;
	private Integer expires_in;
	private String refresh_token;
	private Integer refresh_expires_in;
	private String id_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Integer getRefresh_expires_in() {
		return refresh_expires_in;
	}

	public void setRefresh_expires_in(Integer refresh_expires_in) {
		this.refresh_expires_in = refresh_expires_in;
	}

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

}
