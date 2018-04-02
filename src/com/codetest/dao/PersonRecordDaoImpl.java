package com.codetest.dao;

import static com.codetest.constants.DelimitedFieldMetaData.DATE_OF_BIRTH;
import static com.codetest.constants.DelimitedFieldMetaData.FAVORITE_COLOR;
import static com.codetest.constants.DelimitedFieldMetaData.FIRST_NAME;
import static com.codetest.constants.DelimitedFieldMetaData.GENDER;
import static com.codetest.constants.DelimitedFieldMetaData.LAST_NAME;
import static com.codetest.constants.DelimitedFieldMetaData.MIDDLE_INITIAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codetest.constants.DelimitedFieldMetaData;
import com.codetest.constants.factory.FieldEnumsFactory;
import com.codetest.domain.PersonRecord;
import com.codetest.exception.ApplicationException;

public class PersonRecordDaoImpl implements PersonRecordDao {

	/**
	 * Purpose: PersonRecordDaoImpl is a concrete implementation of
	 * PersonRecordDao. It serves as the access object to the source data from
	 * which the Domain class PersonRecord is created. This Implementation
	 * accesses a File to create the PersonRecord objects and List of
	 * PersonRecords. Subsequent implementations that use a database can be used
	 * by changing only a few areas in the codebase.
	 * 
	 */

	public List<PersonRecord> getPersonRecords(File personDataFile)
			throws ApplicationException {

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(personDataFile));

			String line;
			while ((line = reader.readLine()) != null) {
				
				PersonRecord personRecord = getRecord(line, personDataFile.getName());
				
				personRecords.add(personRecord);
				
			}

		} catch (Exception e) {
			throw new ApplicationException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new ApplicationException(
							"Unable to close BufferedReader", e);
				}
			}
		}
		return personRecords;
	}

	@SuppressWarnings("rawtypes")
	public PersonRecord getRecord(String line, String filePrefix)
			throws ApplicationException {

		PersonRecord personRecord = new PersonRecord();
		try {

			String fieldDelimiter = DelimitedFieldMetaData
					.getDelimiter(filePrefix);
			String fields[] = line.split(fieldDelimiter);

			Enum[] fieldOrdinalsSpecificToThisFileType = FieldEnumsFactory
					.getOrderedFieldsSpecificToFile(filePrefix);
			Enum[] universeOfFields = DelimitedFieldMetaData.values();

			for (int i = 0; i < fieldOrdinalsSpecificToThisFileType.length; i++) {

				for (int j = 0; j < universeOfFields.length; j++) {

					/*
					 * Below, we use the .name() method invoked on the enums to
					 * find the fields in each Enum class specific to each file
					 * type (e.g., FieldEnumsComma) to identify 2 things: 1)
					 * which fields exist in this specific file type (e.g., CSV
					 * files don't have MiddleInitial so that field will be
					 * excluded when doing setting fields); and, 2) which setter
					 * should we call for this specific field... if the Enum
					 * name in the universeOfFields[] matches the one the index
					 * 'i' currently indexes in the
					 * fieldOrdinalsSpecificToThisFileType[] array then we know
					 * which field in PersonRecord we currently need to set
					 */
					if (fieldOrdinalsSpecificToThisFileType[i].name() == universeOfFields[i]
							.name()) {

						if (universeOfFields[i] == LAST_NAME) {
							personRecord.setLastName(fields[LAST_NAME
									.getFieldIndex(filePrefix)].trim());
						}
						if (universeOfFields[i] == FIRST_NAME) {
							personRecord.setFirstName(fields[FIRST_NAME
									.getFieldIndex(filePrefix)].trim());
						}
						if (universeOfFields[i] == GENDER) {
							personRecord.setGender(fields[GENDER
									.getFieldIndex(filePrefix)].trim());
						}
						if (universeOfFields[i] == FAVORITE_COLOR) {
							personRecord.setFavoriteColor(fields[FAVORITE_COLOR
									.getFieldIndex(filePrefix)].trim());
						}
						if (universeOfFields[i] == DATE_OF_BIRTH) {
							personRecord
									.setDateOfBirth(
											fields[DATE_OF_BIRTH
													.getFieldIndex(filePrefix)]
													.trim());
						}
						if (universeOfFields[i] == MIDDLE_INITIAL) {
							personRecord.setMiddleInitial(fields[MIDDLE_INITIAL
									.getFieldIndex(filePrefix)].trim());
						}

					}

				}
			}

		} catch (Exception e) {
			throw new ApplicationException(e);
		}
		return personRecord;
	}

}
