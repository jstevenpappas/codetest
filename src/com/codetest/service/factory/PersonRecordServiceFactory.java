package com.codetest.service.factory;

import com.codetest.service.PersonRecordService;
import com.codetest.service.PersonRecordServiceImpl;

public class PersonRecordServiceFactory {

	private PersonRecordServiceFactory() {/* priv. to prevent instantiation */
	}

	private static final PersonRecordService INSTANCE = new PersonRecordServiceImpl();

	public static PersonRecordService getInstance() {
		return INSTANCE;
	}

}
