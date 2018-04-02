package com.codetest.service;

import java.util.List;

import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.exception.ApplicationException;

public interface PersonRecordService {

	public List<PersonRecord> getPersonRecords(
			PersonRecordDataSource personRecordDataSource)
			throws ApplicationException;
}
