package com.codetest.constants;

import static com.codetest.constants.DataFileConstants.CSV_DATE_OF_BIRTH_INDEX;
import static com.codetest.constants.DataFileConstants.CSV_FAVORITE_COLOR_INDEX;
import static com.codetest.constants.DataFileConstants.CSV_FIRST_NAME_INDEX;
import static com.codetest.constants.DataFileConstants.CSV_GENDER_INDEX;
import static com.codetest.constants.DataFileConstants.CSV_LAST_NAME_INDEX;

import static com.codetest.constants.DataFileConstants.COMMA_DELIMITER;
import static com.codetest.constants.DataFileConstants.PIPE_DELIMITER;
import static com.codetest.constants.DataFileConstants.SPACE_DATE_OF_BIRTH_INDEX;
import static com.codetest.constants.DataFileConstants.SPACE_DELIMITER;
import static com.codetest.constants.DataFileConstants.SPACE_FAVORITE_COLOR_INDEX;
import static com.codetest.constants.DataFileConstants.SPACE_FIRST_NAME_INDEX;
import static com.codetest.constants.DataFileConstants.SPACE_GENDER_INDEX;
import static com.codetest.constants.DataFileConstants.SPACE_LAST_NAME_INDEX;
import static com.codetest.constants.DataFileConstants.SPACE_MIDDLE_INITIAL_INDEX;

import static com.codetest.constants.DataFileConstants.PIPE_DATE_OF_BIRTH_INDEX;
import static com.codetest.constants.DataFileConstants.PIPE_FAVORITE_COLOR_INDEX;
import static com.codetest.constants.DataFileConstants.PIPE_FIRST_NAME_INDEX;
import static com.codetest.constants.DataFileConstants.PIPE_GENDER_INDEX;
import static com.codetest.constants.DataFileConstants.PIPE_LAST_NAME_INDEX;
import static com.codetest.constants.DataFileConstants.PIPE_MIDDLE_INITIAL_INDEX;

import static com.codetest.constants.DataFileConstants.CSV_DATE_FORMAT;
import static com.codetest.constants.DataFileConstants.SPACE_DATE_FORMAT;
import static com.codetest.constants.DataFileConstants.PIPE_DATE_FORMAT;

import static com.codetest.constants.DataFileConstants.FILE_PREFIX_CSV;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_PIPE;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_SPACE;

public enum DelimitedFieldMetaData {

	LAST_NAME {
		@Override
		public int getFieldIndex(String fileName) {
			int field = -1;
			if (fileName.startsWith(FILE_PREFIX_CSV)) {
				field = CSV_LAST_NAME_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_LAST_NAME_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_LAST_NAME_INDEX;
			}
			return field;
		}
	},
	FIRST_NAME {
		@Override
		public int getFieldIndex(String fileName) {
			int field = -1;
			if (fileName.startsWith(FILE_PREFIX_CSV)) {
				field = CSV_FIRST_NAME_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_FIRST_NAME_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_FIRST_NAME_INDEX;
			}
			return field;
		}
	},
	GENDER {
		@Override
		public int getFieldIndex(String fileName) {
			int field = -1;
			if (fileName.startsWith(FILE_PREFIX_CSV)) {
				field = CSV_GENDER_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_GENDER_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_GENDER_INDEX;
			}
			return field;
		}
	},
	FAVORITE_COLOR {
		@Override
		public int getFieldIndex(String fileName) {
			int field = -1;
			if (fileName.startsWith(FILE_PREFIX_CSV)) {
				field = CSV_FAVORITE_COLOR_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_FAVORITE_COLOR_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_FAVORITE_COLOR_INDEX;
			}
			return field;
		}
	},
	DATE_OF_BIRTH {
		@Override
		public int getFieldIndex(String filename) {
			int field = -1;
			if (filename.startsWith(FILE_PREFIX_CSV)) {
				field = CSV_DATE_OF_BIRTH_INDEX;
			} else if (filename.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_DATE_OF_BIRTH_INDEX;
			} else if (filename.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_DATE_OF_BIRTH_INDEX;
			}
			return field;
		}

		@Override
		public String getDateFormat(String filename) {
			String dateFormat = null;
			if (filename.startsWith(FILE_PREFIX_CSV)) {
				dateFormat = CSV_DATE_FORMAT;
			} else if (filename.startsWith(FILE_PREFIX_SPACE)) {
				dateFormat = SPACE_DATE_FORMAT;
			} else if (filename.startsWith(FILE_PREFIX_PIPE)) {
				dateFormat = PIPE_DATE_FORMAT;
			}
			return dateFormat;
		}
	},
	MIDDLE_INITIAL {
		@Override
		public int getFieldIndex(String fileName) {
			int field = -1;
			if (fileName.startsWith(FILE_PREFIX_SPACE)) {
				field = SPACE_MIDDLE_INITIAL_INDEX;
			} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
				field = PIPE_MIDDLE_INITIAL_INDEX;
			}
			return field;
		}
	};

	public static String getDelimiter(String fileName) {
		String returnVal = "";
		if (fileName.startsWith(FILE_PREFIX_CSV)) {
			returnVal = COMMA_DELIMITER;
		} else if (fileName.startsWith(FILE_PREFIX_PIPE)) {
			returnVal = PIPE_DELIMITER;
		} else if (fileName.startsWith(FILE_PREFIX_SPACE)) {
			returnVal = SPACE_DELIMITER;
		}
		return returnVal;
	}

	/*
	 * Token template-like methods below provide skeleton for methods specific
	 * for each enum above to override - if a matching method doesn't exist
	 * outside the Enum body, then the method inside each Enum will not have
	 * visibility... This is a feature specific to Enums in Java
	 */
	public int getFieldIndex(String fileName) {
		return -1;
	}

	public String getDateFormat(String filename) {
		return "";
	}

}
