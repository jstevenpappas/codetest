package com.codetest.constants;

/**
 * Commonly used static constants
 */
public class DataFileConstants {

	public static String FILE_PREFIX_CSV = "comma";
	public static String FILE_PREFIX_SPACE = "space";
	public static String FILE_PREFIX_PIPE = "pipe";
	public static String FILE_EXTENSION = ".txt";

	public static String COMMA_DELIMITER = ",";
	public static String SPACE_DELIMITER = " ";
	public static String PIPE_DELIMITER = "\\|";

	// CSV field index constants
	public static int CSV_LAST_NAME_INDEX = 0;
	public static int CSV_FIRST_NAME_INDEX = 1;
	public static int CSV_GENDER_INDEX = 2;
	public static int CSV_FAVORITE_COLOR_INDEX = 3;
	public static int CSV_DATE_OF_BIRTH_INDEX = 4;

	// space field index constants
	public static int SPACE_LAST_NAME_INDEX = 0;
	public static int SPACE_FIRST_NAME_INDEX = 1;
	public static int SPACE_GENDER_INDEX = 3;
	public static int SPACE_FAVORITE_COLOR_INDEX = 5;
	public static int SPACE_DATE_OF_BIRTH_INDEX = 4;
	public static int SPACE_MIDDLE_INITIAL_INDEX = 2;

	// pipe field index constants
	public static int PIPE_LAST_NAME_INDEX = 0;
	public static int PIPE_FIRST_NAME_INDEX = 1;
	public static int PIPE_GENDER_INDEX = 3;
	public static int PIPE_FAVORITE_COLOR_INDEX = 4;
	public static int PIPE_DATE_OF_BIRTH_INDEX = 5;
	public static int PIPE_MIDDLE_INITIAL_INDEX = 2;

	// date formats
	public static String CSV_DATE_FORMAT = "M/d/yyyy";
	public static String SPACE_DATE_FORMAT = "M-d-yyyy";
	public static String PIPE_DATE_FORMAT = "M-d-yyyy";

}
