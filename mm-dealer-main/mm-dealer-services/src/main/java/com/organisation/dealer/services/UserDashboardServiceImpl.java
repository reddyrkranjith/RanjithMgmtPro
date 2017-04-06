package com.organisation.dealer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.repository.UserDashboardRepository;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;
import com.organisation.dealer.repository.exception.ManagmentServiceErrorCodes;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service("UserDashboardService")
public class UserDashboardServiceImpl implements UserDashboardService {
	
	@Autowired
	@Qualifier("UserDashboardRepository")
	UserDashboardRepository dashboardRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public List<DepartmentEntity> getAllDepartments()
			throws ManagmentServiceException {
		List<DepartmentEntity> users = null;
		try {
			users= dashboardRepository.getAllDepartments();
		}catch(ManagmentRepositoryException e) {
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
		return users;
	}
}
