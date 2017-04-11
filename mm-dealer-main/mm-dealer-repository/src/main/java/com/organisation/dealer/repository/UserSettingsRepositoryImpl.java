package com.organisation.dealer.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.beans.StudentsSearchBeans;
import com.organisation.dealer.entities.DepartmentEntity;
import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.entities.StudentsAcadamicsEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Repository("UserSettingsRepository")
public class UserSettingsRepositoryImpl implements UserSettingsRepository {
	
	protected static final Logger LOG_R = Logger.getLogger(UserSettingsRepositoryImpl.class);
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<MgmtUserEntity> getStudentsBasedOnDeptAndSemister(
			StudentsSearchBeans beans) throws ManagmentRepositoryException {
		List<MgmtUserEntity> entity = null;
		List<DepartmentEntity> departments = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			/*Criteria criteria = session.createCriteria(MgmtUserEntity.class, "user");
			criteria.createAlias("user.studentsAcadamicsEntity", "acadamics");
			criteria.createAlias("acadamics.departmentEntity", "department");
			criteria.add(Restrictions.eq("department.deptName", beans.getDepartment()));
			entity = criteria.list();*/
		} catch (HibernateException e) {
			LOG_R.error("Exception "+e.getMessage());
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}

		return entity;
	}

}
