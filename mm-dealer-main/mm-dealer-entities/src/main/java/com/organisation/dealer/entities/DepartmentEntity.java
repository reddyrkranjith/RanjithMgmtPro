package com.organisation.dealer.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "DepartmentEntity")
@Table(name = "tbl_departments")
public class DepartmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279498922439820737L;
	
	@Id
	@GeneratedValue
	@Column(name = "dept_id", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "dept_name", nullable = false, updatable = false)
	private String department;
	
	@Column(name = "dept_description", nullable = false, updatable = true)
	private String details;
	
	@Column(name = "dept_cover", nullable = false, updatable = true)
	private String deptCover;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
	private List<SubjectsEntity> subject;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDeptCover() {
		return deptCover;
	}

	public void setDeptCover(String deptCover) {
		this.deptCover = deptCover;
	}

	public List<SubjectsEntity> getSubject() {
		return subject;
	}

	public void setSubject(List<SubjectsEntity> subject) {
		this.subject = subject;
	}
}
