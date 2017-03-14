package com.organisation.dealer.web.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.organisation.dealer.services.exception.ManagmentServiceException;

@ControllerAdvice
public class GlobalExceptionController {

	protected static final Logger LOG_R = Logger.getLogger(GlobalExceptionController.class);
	
	/**
	 * All The exceptions in the application are wrapped to {SplashServiceException}
	 * 
	 * For each and every exception there should be a error code to define contract for 
	 * client applications.
	 * 
	 * Use specific error codes for each and every  type of exception.
	 *  
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ManagmentServiceException.class)
	public ModelAndView handleAllException(ManagmentServiceException ex) {
		ModelAndView model = new ModelAndView("/generic_error");
		model.addObject("errMsg", ex.getMessage());
		return model;
	}
}
