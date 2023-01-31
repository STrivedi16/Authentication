package com.example.authentication.Responce;

public class Successtoken {

	String message;

	String key;

	String Accesstoken;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAccesstoken() {
		return Accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		Accesstoken = accesstoken;
	}

	public Successtoken(String message, String key, String accesstoken) {
		super();
		this.message = message;
		this.key = key;
		Accesstoken = accesstoken;
	}

	public Successtoken() {
		super();
		// TODO Auto-generated constructor stub
	}

}
