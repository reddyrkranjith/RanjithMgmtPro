package com.organisation.dealer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "SubjectsEntity")
@Table(name = "tbl_subjects")
public class SubjectsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841096569016794301L;
	
	@Id
	@GeneratedValue
	@Column(name = "sub_id", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "sub_name", nullable = false, updatable = true)
	private String subjectName;
	
	@Column(name = "sub_description", nullable = true, updatable = true)
	private String subjectDesc;
	
	@Column(name = "sub_cover", nullable = false, updatable = true)
	private String subjectCover;
	
	@Column(name = "sub_year", nullable = false, updatable = true)
	private Integer year;
	
	@Column(name = "semister", nullable = false, updatable = true)
	private Integer semister;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_departments_dept_id")
	private DepartmentEntity department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

	public String getSubjectCover() {
		return subjectCover;
	}

	public void setSubjectCover(String subjectCover) {
		this.subjectCover = subjectCover;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemister() {
		return semister;
	}

	public void setSemister(Integer semister) {
		this.semister = semister;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
}
