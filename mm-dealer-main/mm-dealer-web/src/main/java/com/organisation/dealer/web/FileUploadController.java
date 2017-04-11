package com.organisation.dealer.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.organisation.dealer.services.FileUploadServices;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Controller
public class FileUploadController {
	
	private static final Logger LOG_R = Logger.getLogger(FileUploadController.class);
	
	@Autowired
	@Qualifier("FileUploadServices")
	private FileUploadServices fileUploadServices;
	
	/**
	 * Upload single file using Spring Controller
	 * @throws ManagmentServiceException 
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) throws ManagmentServiceException {
		if (!file.isEmpty()) {
			fileUploadServices.readUserDataFromFile(file);
			return "You successfully uploaded file=";
		} else {
			return "You failed to upload because the file was empty.";
		}
	}
}
