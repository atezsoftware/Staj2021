package com.atez.inventory.manager.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ErrorCodes implements ErrorCode {

	SYSTEM_FAILURE(-1,"ErrorCodes.SYSTEM_FAILURE", HttpStatus.INTERNAL_SERVER_ERROR),

	COULD_NOT_FOUND_CATEGORY_TYPE(100,"ErrorCodes.COULD_NOT_FOUND_CATEGORY_TYPE", HttpStatus.NO_CONTENT),
	COULD_NOT_FOUND_INVENTORY(101,"ErrorCodes.COULD_NOT_FOUND_CATEGORY_TYPE", HttpStatus.NO_CONTENT),
	AUTHENTICATION_FAILED(102,"ErrorCodes.AUTHENTICATION_FAILED",HttpStatus.UNAUTHORIZED),
	COULD_NOT_FOUND_USER(102,"ErrorCodes.AUTHENTICATION_FAILED",HttpStatus.NO_CONTENT),
	INVENTORY_ALREADY_ASSINGED(102,"ErrorCodes.INVENTORY_ALREADY_ASSINGED",HttpStatus.BAD_REQUEST);



	private ErrorCodes(Integer code, String langKey, HttpStatus httpStatus) {
		this.setCode(code);
		this.setHttpStatus(httpStatus);
		this.langKey=langKey;
	}

	
	private Integer code;
	
	
	private String langKey;

	
	private HttpStatus httpStatus;

	/**
	 * @param code
	 * @return
	 */
	public ErrorCodes findByCode(Integer code) {
		return Arrays.asList(ErrorCodes.values()).stream().filter(f -> f.getCode().equals(code)).findFirst().orElse(ErrorCodes.SYSTEM_FAILURE);
	}

	@Override
	public String getName() {
		return this.name();
	}

	@Override
	public String langKey() {
		return this.langKey;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
