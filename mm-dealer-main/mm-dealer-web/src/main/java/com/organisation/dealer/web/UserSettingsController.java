package com.organisation.dealer.web;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.organisation.dealer.beans.StudentsResultsBeans;
import com.organisation.dealer.beans.StudentsSearchBeans;
import com.organisation.dealer.beans.enums.AcadamicSemister;
import com.organisation.dealer.beans.enums.AcadamicYear;
import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.services.UserDashboardService;
import com.organisation.dealer.services.UserSettingsService;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Controller
public class UserSettingsController {
	
	protected static final Logger LOG_R = Logger.getLogger(UserSettingsController.class);
	
	@Autowired
	@Qualifier("UserDashboardService")
	UserDashboardService dashboardService;
	
	@Autowired
	@Qualifier("UserSettingsService")
	UserSettingsService settingsService;
	
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(AcadamicYear.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String value) throws IllegalArgumentException {
				if(StringUtils.isBlank(value))
					return;
				setValue(AcadamicYear.valueOf(value));
			}
			@Override
			public String getAsText() {
				if(getValue() == null)
					return "";
				return ((AcadamicYear) getValue()).name();
			}
			
		});
		binder.registerCustomEditor(AcadamicSemister.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String value) throws IllegalArgumentException {
				if(StringUtils.isBlank(value))
					return;
				setValue(AcadamicSemister.valueOf(value));
			}
			@Override
			public String getAsText() {
				if(getValue() == null)
					return "";
				return ((AcadamicSemister) getValue()).name();
			}
			
		});
	}
	
	/**
	 * @param model
	 * @return
	 * @throws ManagmentServiceException
	 */
	@RequestMapping(value = "/settings" , method = RequestMethod.GET)
	public String getUserSettings(Model model) throws ManagmentServiceException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<DepartmentEntity> departments= null;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			departments =  dashboardService.getAllDepartments();
			model.addAttribute("departments", departments);
			model.addAttribute("acadamicYears", AcadamicYear.values());
			model.addAttribute("acadamicSemisters", AcadamicSemister.values());
			model.addAttribute("searchForm", new StudentsSearchBeans());
		}
		return "settings";
	}
	
	/**
	 * @param searchForm
	 * @return 
	 * @throws ManagmentServiceException
	 */
	@RequestMapping(value = "/getStudents", method = RequestMethod.POST)
	@ResponseBody
	public List<StudentsResultsBeans> getStudentsBasedOnSemister(@RequestBody StudentsSearchBeans searchForm) throws ManagmentServiceException{
		
		List<StudentsResultsBeans> students = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			students = settingsService.getStudentsBasedOnDeptAndSemister(searchForm);
		}
		LOG_R.info("Uers "+students.size());
		return students;
	}
}
