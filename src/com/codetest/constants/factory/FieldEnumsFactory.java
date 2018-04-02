package com.codetest.constants.factory;

import static com.codetest.constants.DataFileConstants.FILE_PREFIX_CSV;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_PIPE;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_SPACE;

import com.codetest.constants.FieldEnumsComma;
import com.codetest.constants.FieldEnumsSpace;
import com.codetest.constants.FieldEnumsPipe;

public final class FieldEnumsFactory {

	private FieldEnumsFactory() {/* priv. to prevent instantiation */
	}

	@SuppressWarnings("rawtypes")
	public static Enum[] getOrderedFieldsSpecificToFile(String fileName) {
		Enum[] fieldValuesSpecificToFileDelimiter = null;

		if (fileName.startsWith(FILE_PREFIX_CSV)) {

			fieldValuesSpecificToFileDelimiter = FieldEnumsComma.values();

		} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {

			fieldValuesSpecificToFileDelimiter = FieldEnumsSpace.values();

		} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {

			fieldValuesSpecificToFileDelimiter = FieldEnumsPipe.values();

		}
		return fieldValuesSpecificToFileDelimiter;
	}

}
