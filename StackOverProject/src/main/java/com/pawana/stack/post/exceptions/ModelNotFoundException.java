package com.pawana.stack.post.exceptions;

public class ModelNotFoundException extends RuntimeException {
	private String errorCode;
	private String errorMessage;
	public ModelNotFoundException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ModelNotFoundException(String string) {
		super();
	}

	
}
