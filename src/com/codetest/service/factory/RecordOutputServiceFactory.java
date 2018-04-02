package com.codetest.service.factory;

import com.codetest.service.RecordOutputService;
import com.codetest.service.RecordOutputServiceImpl;

public class RecordOutputServiceFactory {

	private RecordOutputServiceFactory() {/* priv. to prevent instantiation */
	}

	private static final RecordOutputService INSTANCE = new RecordOutputServiceImpl();

	public static RecordOutputService getInstance() {
		return INSTANCE;
	}

}
