package com.codetest.main;

import static com.codetest.constants.DataFileConstants.FILE_EXTENSION;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_CSV;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_PIPE;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_SPACE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.service.PersonRecordService;
import com.codetest.service.RecordOutputService;
import com.codetest.service.factory.PersonRecordServiceFactory;
import com.codetest.service.factory.RecordOutputServiceFactory;

public class CodetestDriver {

	/**
	 * Codetest Project John Pappas
	 * 
	 * Purpose: main() method INPUT -gets references to PersonData files
	 * (assumed to be in classpath) -uses files to build PersonRecordDataSource
	 * object to pass to service method -service method returns List of
	 * PersonRecords OUTPUT -main() now sorts and outputs the PersonRecords
	 * contained in the List in 3 different ways according to requirements: a)
	 * GenderThenLastNameComparator; b) DateComparator; and, c)
	 * LastNameComparator.
	 */

	public static void main(String[] args) {

		PersonRecordDataSource personRecordDataSource = new PersonRecordDataSource();
		PersonRecordService personRecordService = PersonRecordServiceFactory
				.getInstance();
		RecordOutputService recordOutputService = RecordOutputServiceFactory
				.getInstance();

		try {

			personRecordDataSource.setCsvFile(new File(FILE_PREFIX_CSV
					+ FILE_EXTENSION));
			personRecordDataSource.setSsvFile(new File(FILE_PREFIX_SPACE
					+ FILE_EXTENSION));
			personRecordDataSource.setPsvFile(new File(FILE_PREFIX_PIPE
					+ FILE_EXTENSION));

			List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
			personRecords = personRecordService
					.getPersonRecords(personRecordDataSource);

			recordOutputService
					.getFemaleBeforeMaleThenLastNameAscendingOrderStdOut(personRecords);

			recordOutputService.getDateAscendingOrderStdOut(personRecords);

			recordOutputService.getLastNameDescendingOrderStdOut(personRecords);

		} catch (Exception e) {
			// should never happen right???
			e.printStackTrace();
		}

	}

}
