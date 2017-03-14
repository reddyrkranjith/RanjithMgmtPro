package com.organisation.dealer.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.organisation.dealer.beans.ForgotPasswordBeans;
import com.organisation.dealer.beans.ResetPasswordBeans;
import com.organisation.dealer.beans.UserBeans;
import com.organisation.dealer.entities.UserEntity;
import com.organisation.dealer.services.UserAuthenticationService;
import com.organisation.dealer.services.exception.ManagmentServiceException;

/**
 * @author Ranjith reddy
 *
 */
@Controller
public class UserAuthenticationController {
	protected static final Logger LOG_R = Logger.getLogger(UserAuthenticationController.class);
	
	@Autowired
	@Qualifier("UserAuthenticationService")
	UserAuthenticationService userAuthenticationService;
	
	/**
	 * @param error
	 * @param model
	 * @return
	 * @throws ManagmentServiceException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="error", required=false) boolean error, ModelMap model) throws ManagmentServiceException {
		
		ModelAndView modelView = new ModelAndView("login");
		modelView.addObject("user", new UserBeans());
		if (error == true) {
			modelView.addObject("errors", "You have entered an invalid username or password!");
        } else {
        	modelView.addObject("errors", "");
        }
		return modelView;
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) throws ManagmentServiceException{
        return "redirect:/login";
    }
	
	@RequestMapping(value = "/forgotpassword", method= RequestMethod.GET)
	public String forgotPassword(Model model) throws ManagmentServiceException{
		model.addAttribute("forgotPass", new ForgotPasswordBeans());
		return "forgotpassword";
	}
	
	@RequestMapping(value = "/forgotpassword", method= RequestMethod.POST)
	public String forgotPassword(@Valid ForgotPasswordBeans forgotPass,
            BindingResult result, Model model, RedirectAttributes redirectAttributes) throws ManagmentServiceException{
		
		if (result.hasErrors()) {
            return "forgotpassword";
        } else {
        	UserEntity user= userAuthenticationService.getUserByUserEmail(forgotPass.getEmail());
        	if(user == null){
        		model.addAttribute("error", "User do not exits.");
        		model.addAttribute("forgotPass", new ForgotPasswordBeans());
				return "forgotpassword";
        	}else {
        		userAuthenticationService.generatePasswordResetLink(forgotPass.getEmail());
        		redirectAttributes.addFlashAttribute("success","Details Sent Successfully.");
				return "redirect:forgotpassword";
        	}
        }
	}
	
	@RequestMapping(value = "/resetpassword/{token}", method= RequestMethod.GET)
	public String resetPassword(@PathVariable(value="token") String token, Model model, RedirectAttributes redirectAttributes) throws ManagmentServiceException{
		boolean isValidToken = userAuthenticationService.isPasswordResetTokenValid(token);
		if(isValidToken){
			ResetPasswordBeans resetPasswordBeans = new ResetPasswordBeans();
			resetPasswordBeans.setToken(token);
			model.addAttribute("resetPass", resetPasswordBeans);
			return "resetpassword";
		} else {
			model.addAttribute("error", "It looks like you clicked on an invalid password reset link. Please try again.");
    		model.addAttribute("forgotPass", new ForgotPasswordBeans());
			return "forgotpassword";
		}
	}
	
	@RequestMapping(value = "/resetpassword", method= RequestMethod.POST)
	public String resetPassword(@Valid ResetPasswordBeans resetPasswordBeans,
            BindingResult result, Model model) throws ManagmentServiceException{
		if (result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("resetPass", resetPasswordBeans);
            return "resetpassword";
        } else {
        	userAuthenticationService.updateUserCredentials(resetPasswordBeans);
        	return "redirect:/login";
        }
	}
}
