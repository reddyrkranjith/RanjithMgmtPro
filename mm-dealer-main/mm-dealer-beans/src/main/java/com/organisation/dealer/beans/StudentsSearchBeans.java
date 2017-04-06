package com.organisation.dealer.beans;

import java.io.Serializable;

import com.organisation.dealer.beans.enums.AcadamicSemister;
import com.organisation.dealer.beans.enums.AcadamicYear;

public class StudentsSearchBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -478407613582220521L;
	
	private String department;
	
	private AcadamicYear year;
	
	private AcadamicSemister semister;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public AcadamicYear getYear() {
		return year;
	}
	public void setYear(AcadamicYear year) {
		this.year = year;
	}
	public AcadamicSemister getSemister() {
		return semister;
	}
	public void setSemister(AcadamicSemister semister) {
		this.semister = semister;
	}
}
