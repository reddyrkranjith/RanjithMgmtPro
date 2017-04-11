package com.organisation.dealer.web.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.organisation.dealer.beans.MgmtError;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@ControllerAdvice
public class GlobalExceptionController {

	protected static final Logger LOG_R = Logger.getLogger(GlobalExceptionController.class);
	
    @ExceptionHandler(ManagmentServiceException.class)
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
	public @ResponseBody MgmtError handleAllException(ManagmentServiceException ex) {
    	MgmtError error = new MgmtError();
		error.setErrorCode(ex.getErrorCode());
		error.setErrorMessage(ex.getMessage());
		return error;
	}
 
}
