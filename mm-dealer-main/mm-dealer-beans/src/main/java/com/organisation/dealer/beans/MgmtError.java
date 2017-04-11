package com.organisation.dealer.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This Class holds a service error.
 * 
 * @author Harinath Gariga
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "MgmtError")
public class MgmtError implements Serializable{

	private static final long serialVersionUID = 2221870515087543853L;
	
	@XmlElement
	private Integer errorCode;
	
	@XmlElement
	private String errorMessage;

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
