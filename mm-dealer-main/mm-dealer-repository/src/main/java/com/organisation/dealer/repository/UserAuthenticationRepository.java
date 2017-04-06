package com.organisation.dealer.repository;

import org.springframework.stereotype.Repository;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.entities.PasswordResetTokenEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository
public interface UserAuthenticationRepository {
	
	/**
	 * @param userId
	 * @return
	 * @throws ManagmentRepositoryException
	 */
	public MgmtUserEntity getUserByUserID(String userId)throws ManagmentRepositoryException;
	
	/**
	 * @param email
	 * @return
	 * @throws ManagmentRepositoryException
	 */
	public MgmtUserEntity getUserByUserEmail(String email) throws ManagmentRepositoryException;

	/**
	 * @param hasedToken
	 * @param expiryDate
	 * @param email
	 * @throws ManagmentRepositoryException
	 */
	public void updatePasswordResetHash(PasswordResetTokenEntity entity)throws ManagmentRepositoryException;

	/**
	 * @param email
	 * @return
	 */
	public PasswordResetTokenEntity getUserPasswordResetTokens(String email) throws ManagmentRepositoryException;

	/**
	 * @param token
	 * @return
	 * @throws ManagmentRepositoryException
	 */
	public PasswordResetTokenEntity isPasswordResetTokenExits(String token) throws ManagmentRepositoryException;

	/**
	 * @param userEntity
	 * @throws ManagmentRepositoryException
	 */
	public void updateUserCredentials(MgmtUserEntity userEntity) throws ManagmentRepositoryException;
}
