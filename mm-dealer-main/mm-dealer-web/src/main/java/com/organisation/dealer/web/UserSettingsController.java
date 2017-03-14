package com.organisation.dealer.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.services.UserDashboardService;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Controller
public class UserSettingsController {
	
	protected static final Logger LOG_R = Logger.getLogger(UserSettingsController.class);
	
	@Autowired
	@Qualifier("UserDashboardService")
	UserDashboardService dashboardService;
	
	@RequestMapping(value = "/settings" , method = RequestMethod.GET)
	public String getUserSettings(Model model) throws ManagmentServiceException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<DepartmentEntity> departments= null;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			/*departments =  dashboardService.getAllDepartmentDetails();*/
			model.addAttribute("departments", departments);
		}
		return "settings";
	}
}
