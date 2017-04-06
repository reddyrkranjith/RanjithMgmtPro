package com.organisation.dealer.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.organisation.dealer.entities.MgmtUserEntity;
import com.organisation.dealer.entities.MgmtUserProfileEntity;
import com.organisation.dealer.entities.UserRole;
import com.organisation.dealer.repository.MgmtUserRepository;
import com.organisation.dealer.repository.exception.ManagmentRepositoryException;
import com.organisation.dealer.repository.exception.ManagmentServiceErrorCodes;
import com.organisation.dealer.services.exception.ManagmentServiceException;

@Service("FileUploadServices")
public class FileUploadServicesImpl implements FileUploadServices {
	
	private static final Logger LOG_R = Logger.getLogger(FileUploadServicesImpl.class);
	
	@Autowired
	@Qualifier("MgmtUserRepository")
	private MgmtUserRepository mgmtUserRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ManagmentServiceException.class)
	public List<MgmtUserEntity> readUserDataFromFile(MultipartFile file)
			throws ManagmentServiceException {
		List<MgmtUserEntity> users = new ArrayList<>();
		try {
			readUserDataFromSpreadSheet(file, users);
			mgmtUserRepository.registerUsers(users);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(ManagmentRepositoryException e) {
			LOG_R.info("Exception : "+e.getMessage());
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}finally{
			
		}
		return users;
	}
	
	@SuppressWarnings("deprecation")
	private void readUserDataFromSpreadSheet(MultipartFile file, List<MgmtUserEntity> users) throws IOException, ManagmentServiceException {
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if(checkIfRowIsEmpty(nextRow))
					continue;
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				MgmtUserEntity user = new MgmtUserEntity();
				MgmtUserProfileEntity profileEntity = new MgmtUserProfileEntity();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					switch (nextCell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						switch (columnIndex) {
						case 0:
							user.setUserId(String.valueOf(nextCell.getNumericCellValue()));
							break;
						case 1:
							profileEntity.setFirstName(String.valueOf(nextCell.getNumericCellValue()));
							profileEntity.setLastName(String.valueOf(nextCell.getNumericCellValue()));
							break;
						case 2:
							profileEntity.setMobile(String.valueOf(nextCell.getNumericCellValue()));
							break;
						case 3:
							user.setEmail(String.valueOf(nextCell.getNumericCellValue()));
							break;
						case 6:
							break;
						case 7:
							profileEntity.setUniqueId(String.valueOf(nextCell.getNumericCellValue()));
							break;
						case 8:
							user.setPassword(String.valueOf(nextCell.getNumericCellValue()));
							break;
						}
						break;
					case Cell.CELL_TYPE_STRING:
						switch (columnIndex) {
						case 0:
							user.setUserId(nextCell.getStringCellValue());
							break;
						case 1:
							profileEntity.setFirstName(nextCell.getStringCellValue());
							profileEntity.setLastName(nextCell.getStringCellValue());
							break;
						case 2:
							profileEntity.setMobile(nextCell.getStringCellValue());
							break;
						case 3:
							user.setEmail(nextCell.getStringCellValue());
							break;
						case 6:
							break;
						case 7:
							profileEntity.setUniqueId(nextCell.getStringCellValue());
							break;
						case 8:
							user.setPassword(nextCell.getStringCellValue());
							break;
						}
						break;
					}
				}
				user.setRole(UserRole.STUDENT);
				profileEntity.setMgmtUserEntity(user);
				user.setMgmtUserProfileEntity(profileEntity);
				users.add(user);
			}
		} catch (IOException e) {
			LOG_R.error("Exception "+e.getMessage());
			throw new ManagmentServiceException(ManagmentServiceErrorCodes.EXCEPTION_OCCURED,
					ManagmentServiceErrorCodes.SERVICE_EXCEPTION_CODE);
		}finally{
			workbook.close();
		}
	}

	private boolean checkIfRowIsEmpty(Row row) {
	    if (row == null) {
	        return true;
	    }
	    if (row.getLastCellNum() <= 0) {
	        return true;
	    }
	    boolean isEmptyRow = true;
	    for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
	        Cell cell = row.getCell(cellNum);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && StringUtils.isNotBlank(cell.toString())) {
	            isEmptyRow = false;
	        }
	    }
	    return isEmptyRow;
	}
}
