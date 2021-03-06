package com.organisation.dealer.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;

@Service("MgmtUserRepository")
public class MgmtUserRepositoryImpl implements MgmtUserRepository {
	
	protected static final Logger LOG_R = Logger.getLogger(MgmtUserRepositoryImpl.class);

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void registerUsers(List<MgmtUserEntity> entities)
			throws ManagmentRepositoryException {
		try {
			MgmtUserEntity entity = null;
			Session session = sessionFactory.getCurrentSession();
			for(MgmtUserEntity userEntity : entities){
				Criteria criteria = session.createCriteria(MgmtUserEntity.class);
				criteria.add(Restrictions.and(Restrictions.eq("userId", userEntity.getUserId()), Restrictions.eq("email", userEntity.getEmail())));
				entity = (MgmtUserEntity) criteria.uniqueResult();
				if(entity == null){
					session.save(userEntity);
				} else {
					throw new ManagmentRepositoryException("Users contains duplicate values for user id"+userEntity.getUserId(),
							ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
				}
			}
			/*for(int i=0;i<entities.size();i++) {
				try{
					session.save(entities.get(i));
				}
				catch (ConstraintViolationException e) {
				    // Ignore the exception here by doing nothing
					entities.get(i).setMgmtUserProfileEntity(new MgmtUserProfileEntity());
				}
				if ( i % 20 == 0 ) { //20, same as the JDBC batch size
			        //flush a batch of inserts and release memory:
			        session.flush();
			        session.clear();
			    }
			}*/
		}
		catch (HibernateException e) {
			LOG_R.info("Exception : "+e.getMessage());
			throw new ManagmentRepositoryException(
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_MESSAGE,
					ManagmentRepositoryException.DATA_ACCESS_EXCEPTION_CODE);
		}
	}
	
	
}
