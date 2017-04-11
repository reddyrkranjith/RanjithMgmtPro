package com.organisation.dealer.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "DepartmentEntity")
@Table(name = "mgmt_tbl_dept")
public class DepartmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279498922439820737L;
	
	@Id
	@GeneratedValue
	@Column(name = "dept_id", nullable = false, updatable = false)
	private Long deptId;
	
	@Column(name = "dept_name", nullable = false, updatable = true)
	private String deptName;
	
	@Column(name = "dept_description", nullable = true, updatable = true)
	private String deptDesc;
	
	@Column(name = "dept_cover", nullable = true, updatable = true)
	private String deptCover;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "departmentEntity")
	private Set<StudentsAcadamicsEntity> acadamicsEntities;
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String getDeptCover() {
		return deptCover;
	}
	public void setDeptCover(String deptCover) {
		this.deptCover = deptCover;
	}
	public Set<StudentsAcadamicsEntity> getAcadamicsEntities() {
		return acadamicsEntities;
	}
	public void setAcadamicsEntities(Set<StudentsAcadamicsEntity> acadamicsEntities) {
		this.acadamicsEntities = acadamicsEntities;
	}
}
