package com.codetest.service;

import java.util.List;

import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.exception.PersonRecordException;

public interface PersonRecordService {

	public List<PersonRecord> getPersonRecords(PersonRecordDataSource personRecordDataSource) throws PersonRecordException;
}
