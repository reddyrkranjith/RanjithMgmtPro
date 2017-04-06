package com.organisation.dealer.beans;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class ForgotPasswordBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	public String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
