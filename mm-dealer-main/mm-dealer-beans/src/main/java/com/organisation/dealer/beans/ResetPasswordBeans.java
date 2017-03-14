package com.organisation.dealer.beans;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.organisation.dealer.beans.custom.validators.PasswordsEqualConstraint;

@PasswordsEqualConstraint(message = "passwords are not equal")
public class ResetPasswordBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String confirmPassword;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
