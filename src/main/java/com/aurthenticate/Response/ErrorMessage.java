package com.aurthenticate.Response;

public class ErrorMessage {

	String errorMessage;

	String errorkey;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorkey() {
		return errorkey;
	}

	public void setErrorkey(String errorkey) {
		this.errorkey = errorkey;
	}

	public ErrorMessage(String errorMessage, String errorkey) {
		super();
		this.errorMessage = errorMessage;
		this.errorkey = errorkey;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
