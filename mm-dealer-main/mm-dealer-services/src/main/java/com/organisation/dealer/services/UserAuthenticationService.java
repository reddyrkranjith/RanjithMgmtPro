package com.organisation.dealer.services;

import org.springframework.stereotype.Service;

import com.organisation.dealer.beans.ResetPasswordBeans;
import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service
public interface UserAuthenticationService {
	
	/**
	 * @param email
	 * @return
	 * @throws ManagmentServiceException
	 */
	public MgmtUserEntity getUserByUserEmail(String email) throws ManagmentServiceException;
	
	/**
	 * @param email
	 * @throws ManagmentServiceException
	 */
	public void generatePasswordResetLink(String email) throws ManagmentServiceException;

	/**
	 * @param token
	 * @return
	 * @throws ManagmentServiceException
	 */
	public boolean isPasswordResetTokenValid(String token) throws ManagmentServiceException;

	/**
	 * @param resetPasswordBeans
	 * @throws ManagmentServiceException
	 */
	public void updateUserCredentials(ResetPasswordBeans resetPasswordBeans) throws ManagmentServiceException;
}
