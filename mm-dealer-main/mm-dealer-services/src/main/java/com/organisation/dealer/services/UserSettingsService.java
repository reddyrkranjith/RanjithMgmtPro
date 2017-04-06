package com.organisation.dealer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.organisation.dealer.beans.StudentsResultsBeans;
import com.organisation.dealer.beans.StudentsSearchBeans;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service
public interface UserSettingsService {
	
	public List<StudentsResultsBeans> getStudentsBasedOnDeptAndSemister(StudentsSearchBeans beans) throws ManagmentServiceException;
}
