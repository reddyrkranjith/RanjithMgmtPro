package com.organisation.dealer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "StudentsAcadamicsEntity")
@Table(name = "mgmt_student_acadamics")
public class StudentsAcadamicsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8163716778474034643L;
	
	@Id
	@GeneratedValue
	@Column(name = "", updatable = false, nullable = false)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private MgmtUserEntity mgmtUserEntity1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private DepartmentEntity departmentEntity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MgmtUserEntity getMgmtUserEntity1() {
		return mgmtUserEntity1;
	}

	public void setMgmtUserEntity1(MgmtUserEntity mgmtUserEntity1) {
		this.mgmtUserEntity1 = mgmtUserEntity1;
	}

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}
}
