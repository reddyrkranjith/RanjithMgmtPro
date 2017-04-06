package com.organisation.dealer.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Service
public interface MgmtUserRepository {
	
	public void registerUsers(List<MgmtUserEntity> entities) throws ManagmentRepositoryException;
}
