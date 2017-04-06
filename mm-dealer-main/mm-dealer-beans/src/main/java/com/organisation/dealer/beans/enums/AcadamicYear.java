package com.organisation.dealer.beans.enums;

public enum AcadamicYear {
	
	FIRST("1st Year"),
	SECOND("2nd Year"),
	THIRD("3rd Year"),
	FOURTH("4th Year");
	
	private String description;
	
	public String getValue() {
		return name();
	}

	public void setValue(String value) {
	}
	
	private AcadamicYear(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
