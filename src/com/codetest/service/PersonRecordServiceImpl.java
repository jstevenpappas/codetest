package com.codetest.service;

import java.util.ArrayList;
import java.util.List;

import com.codetest.dao.PersonRecordDao;
import com.codetest.dao.PersonRecordDaoImpl;
import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.exception.PersonRecordException;

import com.codetest.service.PersonRecordService;

public class PersonRecordServiceImpl implements PersonRecordService {

	/*
	 * Purpose:
	 * Takes in a 'PersonRecordDataSource' object that contains references to source PersonData files.
	 * Invokes DAO on each file to build a List of PersonRecords to return to caller
	 * 
	 */
	@Override
	public List<PersonRecord> getPersonRecords(PersonRecordDataSource personRecordDataSource) throws PersonRecordException {

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		PersonRecordDao personRecordDao = new PersonRecordDaoImpl();
		
		personRecords.addAll(personRecordDao.getPersonRecords(personRecordDataSource.getCsvFile()));
		personRecords.addAll(personRecordDao.getPersonRecords(personRecordDataSource.getSsvFile()));
		personRecords.addAll(personRecordDao.getPersonRecords(personRecordDataSource.getPsvFile()));
		
		return personRecords;
	}

}
