package com.codetest.constants;

import static com.codetest.constants.DataFileConstants.*;

/**
 * 
 * Purpose:
 * Enum object used to signify the order
 * in which each field of the PersonRecord object
 * is set when populated by the DAO.
 * This Enum also encapsulates the index of each
 * field in its properties. 
 * Helper methods allow the calling method to retrieve
 * the correct index by taking the source Person Data file
 * name prefix (e.g., comma from 'comma.txt' filename) as
 * input. 
 *
 */
public enum DelimiterDerivedRecordMetaData {
	
	/*
	 * Comma
	 * 0-Last Name, 1-First Name, 2-Gender, 3-Favorite Color, 4-Date Of Birth
	 * Space
	 * 0-Last Name, 1-First Name, 2-Middle Initial, 3-Gender, 4-Date Of Birth, 5-Favorite Color
	 * Pipe
	 * 0-Last Name, 1-First Name, 2-Middle Initial, 3-Gender, 4-Favorite Color, 5-Date Of Birth
	 */
	
	LAST_NAME(0,0,0),
	FIRST_NAME(1,1,1),
	GENDER(2,3,3),
	FAVORITE_COLOR(3,5,4),
	DATE_OF_BIRTH(4,4,5),
	MIDDLE_INITIAL(-1,2,2); /* -1 because comma files do not contain a 
								MIDDLE_INITIAL field, will cause IOOB exception
							*/
	
	private final int csvElementIndex;
	private final int spaceElementIndex;
	private final int pipeElementIndex;
	
	DelimiterDerivedRecordMetaData(int csvElementIndex, int spaceElementIndex, int pipeElementIndex){
		this.csvElementIndex = csvElementIndex;
		this.spaceElementIndex = spaceElementIndex;
		this.pipeElementIndex = pipeElementIndex;
	}
	
	public static String getDelimiter(String filePrefix){
		String returnVal = "";
		if (filePrefix.startsWith(FILE_PREFIX_CSV)) {
			returnVal = COMMA_DELIMITER;
		} else if (filePrefix.startsWith(FILE_PREFIX_PIPE)) {
			returnVal = PIPE_DELIMITER;
		} else if (filePrefix.startsWith(FILE_PREFIX_SPACE)) {
			returnVal = SPACE_DELIMITER;
		}
		return returnVal;
	}
	public int getIndex(String filePrefix){
		int returnVal = -1;
		if (filePrefix.startsWith(FILE_PREFIX_CSV)) {
			returnVal = csvElementIndex;
		} else if (filePrefix.startsWith(FILE_PREFIX_PIPE)) {
			returnVal = pipeElementIndex;
		} else if (filePrefix.startsWith(FILE_PREFIX_SPACE)) {
			returnVal = spaceElementIndex;
		}
		return returnVal;
	}
}
