package com.organisation.dealer.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.dealer.beans.StudentsResultsBeans;
import com.organisation.dealer.beans.StudentsSearchBeans;
import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.repository.UserSettingsRepository;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;
import com.organisation.dealer.repository.exception.ManagmentServiceErrorCodes;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service("UserSettingsService")
public class UserSettingsServiceImpl implements UserSettingsService {
	
	protected static final Logger LOG_R = Logger.getLogger(UserSettingsServiceImpl.class);
	
	@Autowired
	@Qualifier("UserSettingsRepository")
	UserSettingsRepository settingsRepository;
	
	@Override
	@Transactional
	public List<StudentsResultsBeans> getStudentsBasedOnDeptAndSemister(
			StudentsSearchBeans beans) throws ManagmentServiceException {
		List<StudentsResultsBeans> users = new ArrayList<>();
		try {
			List<MgmtUserEntity> entity = settingsRepository.getStudentsBasedOnDeptAndSemister(beans);
			getStudentsResultsBeans(entity, users);
			LOG_R.info("Uers "+users.size());
		}catch(ManagmentRepositoryException e) {
			LOG_R.error("Exception "+e.getMessage());
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}
		return users;
	}
	
	private void getStudentsResultsBeans(List<MgmtUserEntity> entities, 
			List<StudentsResultsBeans> users) {
		for(MgmtUserEntity entity : entities){
			StudentsResultsBeans bean = new StudentsResultsBeans();
			bean.setId(entity.getId());
			bean.setUserID(entity.getUserId());
			bean.setName(entity.getMgmtUserProfileEntity().getFirstName());
			bean.setMobile(entity.getMgmtUserProfileEntity().getMobile());
			bean.setEmail(entity.getEmail());
			bean.setYear("");
			bean.setSemister("");
			bean.setUniqueId(entity.getMgmtUserProfileEntity().getUniqueId());
			bean.setPassword(entity.getPassword());
			users.add(bean);
		}
	}
}
