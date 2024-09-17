package com.jwt.rest.model;

public class ReqModel {

	 String username;
	 String password;
	public ReqModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public ReqModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ReqModel [username=" + username + ", password=" + password + "]";
	}
	 
}
