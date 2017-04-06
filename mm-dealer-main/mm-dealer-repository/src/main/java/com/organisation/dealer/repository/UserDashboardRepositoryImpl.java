package com.organisation.dealer.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository("UserDashboardRepository")
public class UserDashboardRepositoryImpl implements UserDashboardRepository {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DepartmentEntity> getAllDepartments()
			throws ManagmentRepositoryException {
		List<DepartmentEntity> entity = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(DepartmentEntity.class);
			entity = criteria.list();
		} catch (HibernateException e) {
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}

		return entity;
	}

}
