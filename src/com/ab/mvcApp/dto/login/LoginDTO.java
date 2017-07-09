package com.ab.mvcApp.dto.login;

import java.io.Serializable;

public class LoginDTO implements Serializable {

	private String emailid;
	private String password;
	
	public LoginDTO() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [emailid=" + emailid + ", password=" + password + "]";
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
}
