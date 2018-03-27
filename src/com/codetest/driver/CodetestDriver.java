package com.codetest.driver;

import static com.codetest.constants.DataFileConstants.FILE_PREFIX_CSV;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_SPACE;
import static com.codetest.constants.DataFileConstants.FILE_PREFIX_PIPE;
import static com.codetest.constants.DataFileConstants.FILE_EXTENSION;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.codetest.comparator.DateComparator;
import com.codetest.comparator.GenderThenLastNameComparator;
import com.codetest.comparator.LastNameComparator;

import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.service.PersonRecordService;
import com.codetest.service.PersonRecordServiceImpl;

public class CodetestDriver {

	/**
	 * Codetest Project
	 * John Pappas
	 * 
	 * Purpose: main() method
	 * INPUT
	 *	-gets references to PersonData files (assumed to be in classpath)
	 *	-uses files to build PersonRecordDataSource object to pass to service method
	 *	-service method returns List of PersonRecords
	 *	OUTPUT
	 *	-main() now sorts and outputs the PersonRecords contained in the 
	 *	List in 3 different ways according to requirements:
	 *		a) GenderThenLastNameComparator;
	 *		b) DateComparator; and,
	 *		c) LastNameComparator.
	 */
	
	public static void main(String[] args) {
		
		PersonRecordDataSource personRecordDataSource = new PersonRecordDataSource();
		PersonRecordService personRecordService = new PersonRecordServiceImpl();
			
		try {
			personRecordDataSource.setCsvFile(new File(FILE_PREFIX_CSV + FILE_EXTENSION));
			personRecordDataSource.setSsvFile(new File(FILE_PREFIX_SPACE + FILE_EXTENSION));
			personRecordDataSource.setPsvFile(new File(FILE_PREFIX_PIPE + FILE_EXTENSION));
			
			List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
			personRecords = personRecordService.getPersonRecords(personRecordDataSource);
			
			/*
			 * Sort by Gender then LastName
			 */
			Comparator<PersonRecord> genderThenLastNameComparator = new GenderThenLastNameComparator();
			
			Collections.sort(personRecords, genderThenLastNameComparator);
			System.out.println("Output 1:");
			for(PersonRecord personRecord: personRecords){
				System.out.println(personRecord);
			}
			System.out.println("");
			
			Comparator<PersonRecord> dateComparator = new DateComparator();
			System.out.println("Output 2:");
			Collections.sort(personRecords, dateComparator);
			for(PersonRecord personRecord: personRecords){
				System.out.println(personRecord);
			}
			System.out.println("");
			
			Comparator<PersonRecord> lastNameComparator = new LastNameComparator();
			System.out.println("Output 3:");
			Collections.sort(personRecords, lastNameComparator);
			for(PersonRecord personRecord: personRecords){
				System.out.println(personRecord);
			}
			System.out.println("");
			
			
		} catch (Exception e) {
			/*
			 * usually, I'll at least log the stacktrace
			 * but given this is a code submission/if something happens
			 * we want to see it immediately in the console and not
			 * have to hunt it down in a log
			 */
			e.printStackTrace();
		}

	}

}
