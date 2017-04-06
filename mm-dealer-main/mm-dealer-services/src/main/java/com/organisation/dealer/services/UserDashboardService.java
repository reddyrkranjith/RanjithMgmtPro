package com.organisation.dealer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service
public interface UserDashboardService {
	
	public List<DepartmentEntity> getAllDepartments() throws ManagmentServiceException;
}
