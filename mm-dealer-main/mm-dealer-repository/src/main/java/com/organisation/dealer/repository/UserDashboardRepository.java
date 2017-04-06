package com.organisation.dealer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository
public interface UserDashboardRepository {
	
	public List<DepartmentEntity> getAllDepartments() throws ManagmentRepositoryException;
}
