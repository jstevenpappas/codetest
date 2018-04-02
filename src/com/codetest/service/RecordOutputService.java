package com.codetest.service;

import java.util.List;

import com.codetest.domain.PersonRecord;

public interface RecordOutputService {
	
	public void getFemaleBeforeMaleThenLastNameAscendingOrderStdOut(List<PersonRecord> personRecords);
	public void getDateAscendingOrderStdOut(List<PersonRecord> persoRecord);
	public void getLastNameDescendingOrderStdOut(List<PersonRecord> persoRecord);

}
