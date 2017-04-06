package com.organisation.dealer.web;

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

import com.organisation.dealer.services.UserAuthenticationService;
import com.organisation.dealer.services.UserDashboardService;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Controller
public class UserDashboardController {

	protected static final Logger LOG_R = Logger.getLogger(UserDashboardController.class);

	@Autowired
	@Qualifier("UserAuthenticationService")
	UserAuthenticationService authenticationService;
	
	@Autowired
	@Qualifier("UserDashboardService")
	UserDashboardService dashboardService;

	/**
	 * @return
	 * @throws ManagmentServiceException
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboard(Model model) throws ManagmentServiceException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			/*UserDetails userDetails = (UserDetails) auth.getPrincipal();
			model.addAttribute("user", userDetails.getUsername());*/
		}
		return "dashboard";
	}
}
