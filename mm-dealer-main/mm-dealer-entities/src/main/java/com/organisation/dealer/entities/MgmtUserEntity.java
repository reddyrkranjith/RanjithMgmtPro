package com.organisation.dealer.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "mgmt_tbl_users")
public class MgmtUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2825703428021836760L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	
	@Column(name = "user_role", unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(name = "creation_date", unique = true, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date creationDate;
	
	@Column(name = "modification_date", unique = true, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date modificationDate;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "mgmtUserEntity", cascade = CascadeType.ALL)
	private MgmtUserProfileEntity mgmtUserProfileEntity;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "mgmtUserEntity1", cascade = CascadeType.ALL)
	private StudentsAcadamicsEntity studentsAcadamicsEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public MgmtUserProfileEntity getMgmtUserProfileEntity() {
		return mgmtUserProfileEntity;
	}
	public void setMgmtUserProfileEntity(MgmtUserProfileEntity mgmtUserProfileEntity) {
		this.mgmtUserProfileEntity = mgmtUserProfileEntity;
	}
	public StudentsAcadamicsEntity getStudentsAcadamicsEntity() {
		return studentsAcadamicsEntity;
	}
	public void setStudentsAcadamicsEntity(
			StudentsAcadamicsEntity studentsAcadamicsEntity) {
		this.studentsAcadamicsEntity = studentsAcadamicsEntity;
	}
}
