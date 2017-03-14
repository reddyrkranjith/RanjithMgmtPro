package com.organisation.dealer.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "UserEntity")
@Table(name = "userdetails_tbl")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147426493828540303L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "user_id", updatable = false, nullable = false)
	private String userID;
	
	@Column(name = "first_name", updatable = true, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", updatable = true, nullable = false)
	private String lastName;
	
	@Column(name = "email_id", updatable = false, nullable = false)
	private String email;
	
	@Column(name = "mobile_phone", updatable = true, nullable = false)
	private String mobile;
	
	@Column(name = "uniqueId", updatable = true, nullable = false)
	private String uniqueId;
	
	@Column(name = "password", updatable = true, nullable = false)
	private String password;
	
	@Column(name = "user_role", updatable = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(name = "creation_date", updatable = false, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date creationDate;
	
	@Column(name = "modification_date", updatable = true, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date modificationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}
