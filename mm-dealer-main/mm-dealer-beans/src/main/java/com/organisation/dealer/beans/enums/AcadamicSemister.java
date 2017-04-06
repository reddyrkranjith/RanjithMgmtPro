package com.organisation.dealer.beans.enums;

public enum AcadamicSemister {
	
	FIRST("1st Semister"),
	SECOND("2nd Semister");
	
	private String description;
	
	public String getValue() {
		return name();
	}

	public void setValue(String value) {
	}
	
	private AcadamicSemister(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
