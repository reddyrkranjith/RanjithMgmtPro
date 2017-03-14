package com.organisation.dealer.services;

import java.util.Date;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.beans.ResetPasswordBeans;
import com.organisation.dealer.entities.PasswordResetTokenEntity;
import com.organisation.dealer.entities.UserEntity;
import com.organisation.dealer.repository.UserAuthenticationRepository;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;
import com.organisation.dealer.repository.exception.ManagmentServiceErrorCodes;
import com.organisation.dealer.services.exception.ManagmentServiceException;
import com.organisation.dealer.services.mailutils.Emailer;

@Service("UserAuthenticationService")
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
	
	protected static final Logger LOG_R = Logger.getLogger(UserAuthenticationServiceImpl.class);
	
	private int PASSWORD_RESET_TOKEN_EXPIRE_TIME = 10;
	
	@Autowired
	@Qualifier("UserAuthenticationRepository")
	UserAuthenticationRepository userAuthenticationRepository;
	
	@Autowired
	Emailer emailer;
	
	/* (non-Javadoc)
	 * @see com.organisation.dealer.services.UserAuthenticationService#getUserByUserEmail(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public UserEntity getUserByUserEmail(String email)
			throws ManagmentServiceException {
		UserEntity user = null;
		try {
			user= userAuthenticationRepository.getUserByUserEmail(email);
		}catch(ManagmentRepositoryException e) {
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.organisation.dealer.services.UserAuthenticationService#passwordReset(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public void generatePasswordResetLink(String email) throws ManagmentServiceException {
		UserEntity user = null;
		try {
			user= userAuthenticationRepository.getUserByUserEmail(email);
			if(user == null){
				throw new ManagmentRepositoryException(ManagmentServiceErrorCodes.USER_DOES_NOT_EXIST_WITH_GIVEN_EMAIL, 
						ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
			}else{
				PasswordResetTokenEntity resetTokenEntity = userAuthenticationRepository.getUserPasswordResetTokens(email);
				String hasedToken = UUID.randomUUID().toString();
				Date expiryDate = addMinutesToDate(PASSWORD_RESET_TOKEN_EXPIRE_TIME, new Date());
				if(resetTokenEntity != null){
					resetTokenEntity.setToken(hasedToken);
					resetTokenEntity.setExpiryDate(expiryDate);
					userAuthenticationRepository.updatePasswordResetHash(resetTokenEntity);
				}else {
					userAuthenticationRepository.updatePasswordResetHash(creatPasswordResetTokenEntity(hasedToken, expiryDate, user.getEmail()));
				}
				emailer.send("Password Reset link", hasedToken, email, user.getFirstName()+user.getLastName());
			}
		} catch (ManagmentRepositoryException e) {
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		} catch (MessagingException e) {
			throw new ManagmentServiceException(
					ManagmentServiceErrorCodes.EXCEPTION_OCCURED_WHILE_SENDING_EMAIL,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
	}
	
	private PasswordResetTokenEntity creatPasswordResetTokenEntity(String hasedToken, Date expiryDate, String email) {
		PasswordResetTokenEntity entity= new PasswordResetTokenEntity();
		entity.setToken(hasedToken);
		entity.setExpiryDate(expiryDate);
		entity.setEmail(email);
		return entity;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public boolean isPasswordResetTokenValid(String token)
			throws ManagmentServiceException {
		boolean isValid = false;
		try {
			PasswordResetTokenEntity entity= userAuthenticationRepository.isPasswordResetTokenExits(token);
			if(entity != null && new Date().before(entity.getExpiryDate())){
				isValid = true;
			}
			
		} catch (ManagmentRepositoryException e) {
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
		return isValid;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public void updateUserCredentials(ResetPasswordBeans resetPasswordBeans)
			throws ManagmentServiceException {
		try {
			PasswordResetTokenEntity entity = userAuthenticationRepository
					.isPasswordResetTokenExits(resetPasswordBeans.getToken());
			if(entity != null) {
				UserEntity userEntity= userAuthenticationRepository.getUserByUserEmail(entity.getEmail());
				userEntity.setPassword(resetPasswordBeans.getPassword());
				userEntity.setModificationDate(new Date());
				userAuthenticationRepository.updateUserCredentials(userEntity);
			}
		} catch (ManagmentRepositoryException e) {
			throw new ManagmentServiceException(
					ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
	}
	
	private Date addMinutesToDate(int minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}
}
