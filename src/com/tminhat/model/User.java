package com.tminhat.model;

public class User {
	private String userName;
	private String email;
	private String password;
	
	//constructor
	public User() {}
	public User(String userName, String email, String password){
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "User: " + this.userName + ", email: " + this.email;
	}
}
