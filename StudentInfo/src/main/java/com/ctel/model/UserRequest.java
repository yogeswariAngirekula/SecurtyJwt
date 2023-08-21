package com.ctel.model;

public class UserRequest {
	
	private String emailId;
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRequest(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRequest [emailId=" + emailId + ", password=" + password + "]";
	}

}
