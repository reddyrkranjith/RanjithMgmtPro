package com.organisation.dealer.repository;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.entities.PasswordResetTokenEntity;
import com.organisation.dealer.entities.UserEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository("UserAuthenticationRepository")
public class UserAuthenticationRepositoryImpl implements
		UserAuthenticationRepository {

	protected static final Logger LOG_R = Logger.getLogger(UserAuthenticationRepositoryImpl.class);

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public UserEntity getUserByUserID(String userId)
			throws ManagmentRepositoryException {
		UserEntity entity = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("userID", userId));
			entity = (UserEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			LOG_R.error(
					"Exception occured while getting the user from inventory db",
					e);
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}

		return entity;
	}

	@Override
	@Transactional
	public UserEntity getUserByUserEmail(String email) throws ManagmentRepositoryException {
		UserEntity entity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("email", email));
			entity = (UserEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
		return entity;
	}

	@Override
	@Transactional
	public void updatePasswordResetHash(PasswordResetTokenEntity entity) throws ManagmentRepositoryException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(entity);
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
	}

	@Override
	@Transactional
	public PasswordResetTokenEntity getUserPasswordResetTokens(String email) throws ManagmentRepositoryException{
		PasswordResetTokenEntity entity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(PasswordResetTokenEntity.class);
			criteria.add(Restrictions.eq("email", email));
			entity = (PasswordResetTokenEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
		return entity;
	}

	@Override
	@Transactional
	public PasswordResetTokenEntity isPasswordResetTokenExits(String token)
			throws ManagmentRepositoryException {
		PasswordResetTokenEntity entity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(PasswordResetTokenEntity.class);
			criteria.add(Restrictions.eq("token", token));
			entity = (PasswordResetTokenEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
		return entity;
	}

	@Override
	@Transactional
	public void updateUserCredentials(UserEntity userEntity)
			throws ManagmentRepositoryException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(userEntity);
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
	}

}
