package com.codetest.dao;

import static com.codetest.constants.DelimiterDerivedRecordMetaData.*;
import com.codetest.constants.DataFileConstants;
import com.codetest.constants.DelimiterDerivedRecordMetaData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.codetest.domain.PersonRecord;
import com.codetest.exception.PersonRecordException;

public class PersonRecordDaoImpl implements PersonRecordDao {

	/**
	 * Purpose:
	 * PersonRecordDaoImpl is a concrete implementation of PersonRecordDao.
	 * It serves as the access object to the source data from which the 
	 * Domain class PersonRecord is created.
	 * This Implementation accesses a File to create the PersonRecord objects and 
	 * List of PersonRecords.  Subsequent implementations that use a database can
	 * be used by changing only a few areas in the codebase.
	 * 
	 */
	
	@Override
	public List<PersonRecord> getPersonRecords(File personDataFile) throws PersonRecordException {

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(personDataFile));
			
			String line;
		    while ((line = reader.readLine()) != null)
		    {
		    	PersonRecord personRecord = getPersonRecord(line, personDataFile.getName());
		    	
		    	personRecords.add(personRecord);
		    }
			
		} catch (Exception e) {
			throw new PersonRecordException(e);
		} finally {
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					throw new PersonRecordException("Unable to close BufferedReader", e);
				}
			}			
		}
		return personRecords;
	}
	
	public PersonRecord getPersonRecord(String line, String filePrefix) throws PersonRecordException{
		PersonRecord personRecord = new PersonRecord();
		
		try {
			
		
		String fields[] = line.split(DelimiterDerivedRecordMetaData.getDelimiter(filePrefix));
		for (DelimiterDerivedRecordMetaData metaInfo: DelimiterDerivedRecordMetaData.values()){
			/*
			 * enforce following order using Enums:
			 * 0-Last Name, 1-First Name, 2-Gender, 3-Favorite Color, 4-Date Of Birth
			 */
			switch(metaInfo){
				case LAST_NAME: personRecord.setLastName(fields[LAST_NAME.getIndex(filePrefix)].trim()); break;
				case FIRST_NAME: personRecord.setFirstName(fields[FIRST_NAME.getIndex(filePrefix)].trim()); break;
				case GENDER: personRecord.setGender(fields[GENDER.getIndex(filePrefix)].trim()); break;
				case FAVORITE_COLOR: personRecord.setFavoriteColor(fields[FAVORITE_COLOR.getIndex(filePrefix)].trim()); break;
				case DATE_OF_BIRTH: personRecord.setDateOfBirth(fields[DATE_OF_BIRTH.getIndex(filePrefix)].trim()); break;
				case MIDDLE_INITIAL:
					if(!(filePrefix.startsWith(DataFileConstants.FILE_PREFIX_CSV))){
						personRecord.setMiddleInitial(fields[MIDDLE_INITIAL.getIndex(filePrefix)].trim());
					}
					break;
			}
		}
		} catch (Exception e) {
			throw new PersonRecordException(e);
		}
		return personRecord;
	}

}
