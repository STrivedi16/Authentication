package com.aurthenticate.Response;

public class Success {

	String successMessage;

	String successKey;

	Object object;

	public Success() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Success(String successMessage, String successKey, Object object) {
		super();
		this.successMessage = successMessage;
		this.successKey = successKey;
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getSuccessKey() {
		return successKey;
	}

	public void setSuccessKey(String successKey) {
		this.successKey = successKey;
	}

}
