package com.codetest.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.codetest.comparator.DateComparator;
import com.codetest.comparator.GenderThenLastNameComparator;
import com.codetest.comparator.LastNameComparator;
import com.codetest.domain.PersonRecord;
import com.codetest.service.RecordOutputService;

public class RecordOutputServiceImpl implements RecordOutputService {

	public void getLastNameDescendingOrderStdOut(
			List<PersonRecord> personRecords) {
		@SuppressWarnings("unchecked")
		Comparator<PersonRecord> lastNameComparator = new LastNameComparator();
		System.out.println("Output 3:");
		Collections.sort(personRecords, lastNameComparator);
		for (PersonRecord personRecord : personRecords) {
			System.out.println(personRecord);
		}
		System.out.println("");
	}

	public void getDateAscendingOrderStdOut(List<PersonRecord> personRecords) {
		@SuppressWarnings("unchecked")
		Comparator<PersonRecord> dateComparator = new DateComparator();
		System.out.println("Output 2:");
		Collections.sort(personRecords, dateComparator);
		for (PersonRecord personRecord : personRecords) {
			System.out.println(personRecord);
		}
		System.out.println("");
	}

	public void getFemaleBeforeMaleThenLastNameAscendingOrderStdOut(
			List<PersonRecord> personRecords) {
		@SuppressWarnings("unchecked")
		Comparator<PersonRecord> genderThenLastNameComparator = new GenderThenLastNameComparator();
		System.out.println("Output 1:");
		Collections.sort(personRecords, genderThenLastNameComparator);
		for (PersonRecord personRecord : personRecords) {
			System.out.println(personRecord);
		}
		System.out.println("");
	}

}
