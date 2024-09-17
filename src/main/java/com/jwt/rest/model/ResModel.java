package com.jwt.rest.model;

public class ResModel {

	String token;

	public ResModel(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ResModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
