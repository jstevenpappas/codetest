package com.codetest.dao;

import java.io.File;
import java.util.List;

import com.codetest.domain.PersonRecord;
import com.codetest.exception.PersonRecordException;

public interface PersonRecordDao {

	public List<PersonRecord> getPersonRecords(File personDataFile) throws PersonRecordException;
}
