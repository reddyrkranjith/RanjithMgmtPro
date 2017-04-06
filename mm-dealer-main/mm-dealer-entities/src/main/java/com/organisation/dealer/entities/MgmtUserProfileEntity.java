package com.organisation.dealer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "mgmt_tbl_users_profile")
public class MgmtUserProfileEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 654976346921929516L;
	
	@GenericGenerator(name = "generator", strategy = "foreign",	parameters = @Parameter(name = "property", value = "mgmtUserEntity"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	
	@Column(name = "first_name", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = false)
	private String lastName;
	
	@Column(name = "mobile_phone", unique = false, nullable = false)
	private String mobile;
	
	@Column(name = "uniqueId", unique = false, nullable = true)
	private String uniqueId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private MgmtUserEntity mgmtUserEntity;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public MgmtUserEntity getMgmtUserEntity() {
		return mgmtUserEntity;
	}

	public void setMgmtUserEntity(MgmtUserEntity mgmtUserEntity) {
		this.mgmtUserEntity = mgmtUserEntity;
	}
}
