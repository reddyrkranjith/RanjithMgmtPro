package com.organisation.dealer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.organisation.dealer.beans.StudentsSearchBeans;
import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository
public interface UserSettingsRepository {
	
	public List<MgmtUserEntity> getStudentsBasedOnDeptAndSemister(StudentsSearchBeans beans) throws ManagmentRepositoryException;
}
