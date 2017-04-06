package com.organisation.dealer.services.exception;

public class ManagmentServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3785718067037537153L;
	/**
	 * 
	 */
	public static final int DATA_ACCESS_EXCEPTION_CODE = 2002;
	public static final String DATA_ACCESS_EXCEPTION_MESSAGE = "Data Service exception.";
	
	private String message;
	private int errorCode;
	
	/**
	 * 
	 */
	public ManagmentServiceException() {
		super();
	}
	
	/**
	 * @param mesString
	 * @param errorCode
	 */
	public ManagmentServiceException(String mesString, int errorCode) {
		super(mesString + " :  " + errorCode);
		this.errorCode = errorCode;
		this.message = mesString;
	}
	
	/**
	 * @param e
	 */
	public ManagmentServiceException(Exception e) {
		super(e);
		this.message = e.getMessage();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return message + " : " +errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
