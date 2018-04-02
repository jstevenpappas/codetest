package com.codetest.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ParseUtils {

	private ParseUtils() {/* priv. to prevent instantiation */
	}

	/*
	 * Accepts dates Strings w/ dateformats such as '2/13/1943' and '3-3-1985'
	 * and returns a valid Date instance
	 */
	public static final Date parseDateOfBirthVariations(String dateOfBirth,
			String dateFormat) throws ParseException {

		return new SimpleDateFormat(dateFormat).parse(dateOfBirth);
	}

}
