package com.organisation.dealer.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service
public interface FileUploadServices {
	
	public List<MgmtUserEntity> readUserDataFromFile(MultipartFile file) throws ManagmentServiceException;
}
