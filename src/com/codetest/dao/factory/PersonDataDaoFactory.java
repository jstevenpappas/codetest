package com.codetest.dao.factory;

import com.codetest.dao.PersonRecordDao;
import com.codetest.dao.PersonRecordDaoImpl;

public class PersonDataDaoFactory {

	private PersonDataDaoFactory() {
		{/* priv. to prevent instantiation */
		}
	}

	private static final PersonRecordDao INSTANCE = new PersonRecordDaoImpl();

	public static PersonRecordDao getInstance() {
		return INSTANCE;
	}

}
