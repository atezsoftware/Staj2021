package com.atez.inventory.manager.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


public class CustomException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String SIGN_ERROR_DETAIL = "An unexpected error occurred! Please contact the api support!";

	private final String errorMessage;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final String errorDetail;

	private final ErrorCode errorCode;

	
	public CustomException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getName(), cause);
		this.errorCode = errorCode;
		this.errorMessage = cause.getMessage();
		this.errorDetail = cause.getMessage()!=null ? cause.getMessage() : SIGN_ERROR_DETAIL;
	}
	
	public CustomException(ErrorCode errorCode) {
		super(errorCode.getName());
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getName();
		this.errorDetail=null;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

}
