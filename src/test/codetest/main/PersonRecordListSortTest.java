package test.codetest.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.codetest.comparator.DateComparator;
import com.codetest.comparator.GenderThenLastNameComparator;
import com.codetest.comparator.LastNameComparator;
import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.service.PersonRecordService;
import com.codetest.service.PersonRecordServiceImpl;

public class PersonRecordListSortTest {

	/**
	 * Purpose:
	 * Tests both the retrieval of the List<PersonRecord>
	 * from the service method and also tests the expected
	 * 'sort-order' of the 3 sorting formats specified in 
	 * the requirements.
	 */
	
	private static final Logger log = Logger.getAnonymousLogger();

	private static String CSV_FILE_NAME = "comma.txt";
	private static String SSV_FILE_NAME = "space.txt";
	private static String PSV_FILE_NAME = "pipe.txt";
	private static File CSV_FILE;
	private static File SSV_FILE;
	private static File PSV_FILE;

	@Before
	public void setUpFilesForTest() {
		CSV_FILE = new File(CSV_FILE_NAME);
		SSV_FILE = new File(SSV_FILE_NAME);
		PSV_FILE = new File(PSV_FILE_NAME);

	}

	@Test
	public void testFirstThreePersonInLastNameDescSortedList() throws Exception {
		PersonRecordDataSource personRecordDataSource = new PersonRecordDataSource();

		personRecordDataSource.setCsvFile(CSV_FILE);
		personRecordDataSource.setSsvFile(SSV_FILE);
		personRecordDataSource.setPsvFile(PSV_FILE);

		PersonRecordService prs = new PersonRecordServiceImpl();

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		personRecords = prs.getPersonRecords(personRecordDataSource);

		Comparator<PersonRecord> comparator = new LastNameComparator();
		Collections.sort(personRecords, comparator);

		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Hingis");
		expectedPersonRecord.setFirstName("Martina");
		expectedPersonRecord.setMiddleInitial("M");
		expectedPersonRecord.setGender("Female");
		expectedPersonRecord.setDateOfBirth("4/2/1979");
		expectedPersonRecord.setFavoriteColor("Green");

		PersonRecord expectedPersonRecord2 = new PersonRecord();
		expectedPersonRecord2.setLastName("Kelly");
		expectedPersonRecord2.setFirstName("Sue");
		expectedPersonRecord2.setGender("Female");
		expectedPersonRecord2.setDateOfBirth("7/12/1959");
		expectedPersonRecord2.setFavoriteColor("Pink");

		PersonRecord expectedPersonRecord3 = new PersonRecord();
		expectedPersonRecord3.setLastName("Smith");
		expectedPersonRecord3.setFirstName("Steve");
		expectedPersonRecord3.setMiddleInitial("D");
		expectedPersonRecord3.setGender("M");
		expectedPersonRecord3.setDateOfBirth("3-3-1985");
		expectedPersonRecord3.setFavoriteColor("Red");

		Assert.assertEquals(expectedPersonRecord, personRecords.get(4));
		Assert.assertEquals(expectedPersonRecord2, personRecords.get(3));
		Assert.assertEquals(expectedPersonRecord3, personRecords.get(0));

	}

	@Test
	public void testFirstThreePersonInDateAscSortedList() throws Exception {
		PersonRecordDataSource personRecordDataSource = new PersonRecordDataSource();

		personRecordDataSource.setCsvFile(CSV_FILE);
		personRecordDataSource.setSsvFile(SSV_FILE);
		personRecordDataSource.setPsvFile(PSV_FILE);

		PersonRecordService prs = new PersonRecordServiceImpl();

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		personRecords = prs.getPersonRecords(personRecordDataSource);

		Comparator<PersonRecord> comparator = new DateComparator();
		Collections.sort(personRecords, comparator);

		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Hingis");
		expectedPersonRecord.setFirstName("Martina");
		expectedPersonRecord.setMiddleInitial("M");
		expectedPersonRecord.setGender("Female");
		expectedPersonRecord.setDateOfBirth("4/2/1979");
		expectedPersonRecord.setFavoriteColor("Green");

		PersonRecord expectedPersonRecord2 = new PersonRecord();
		expectedPersonRecord2.setLastName("Kelly");
		expectedPersonRecord2.setFirstName("Sue");
		expectedPersonRecord2.setGender("Female");
		expectedPersonRecord2.setDateOfBirth("7/12/1959");
		expectedPersonRecord2.setFavoriteColor("Pink");

		PersonRecord expectedPersonRecord3 = new PersonRecord();
		expectedPersonRecord3.setLastName("Smith");
		expectedPersonRecord3.setFirstName("Steve");
		expectedPersonRecord3.setMiddleInitial("D");
		expectedPersonRecord3.setGender("M");
		expectedPersonRecord3.setDateOfBirth("3-3-1985");
		expectedPersonRecord3.setFavoriteColor("Red");

		Assert.assertEquals(expectedPersonRecord, personRecords.get(7));
		Assert.assertEquals(expectedPersonRecord2, personRecords.get(1));
		Assert.assertEquals(expectedPersonRecord3, personRecords.get(8));

	}

	@Test
	public void testFirstThreePersonsInGenderSortedList() throws Exception {
		PersonRecordDataSource personRecordDataSource = new PersonRecordDataSource();

		personRecordDataSource.setCsvFile(CSV_FILE);
		personRecordDataSource.setSsvFile(SSV_FILE);
		personRecordDataSource.setPsvFile(PSV_FILE);

		PersonRecordService prs = new PersonRecordServiceImpl();

		List<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		personRecords = prs.getPersonRecords(personRecordDataSource);

		Comparator<PersonRecord> comparator = new GenderThenLastNameComparator();
		Collections.sort(personRecords, comparator);

		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Hingis");
		expectedPersonRecord.setFirstName("Martina");
		expectedPersonRecord.setMiddleInitial("M");
		expectedPersonRecord.setGender("Female");
		expectedPersonRecord.setDateOfBirth("4/2/1979");
		expectedPersonRecord.setFavoriteColor("Green");

		PersonRecord expectedPersonRecord2 = new PersonRecord();
		expectedPersonRecord2.setLastName("Kelly");
		expectedPersonRecord2.setFirstName("Sue");
		expectedPersonRecord2.setGender("Female");
		expectedPersonRecord2.setDateOfBirth("7/12/1959");
		expectedPersonRecord2.setFavoriteColor("Pink");

		PersonRecord expectedPersonRecord3 = new PersonRecord();
		expectedPersonRecord3.setLastName("Kournikova");
		expectedPersonRecord3.setFirstName("Anna");
		expectedPersonRecord3.setMiddleInitial("F");
		expectedPersonRecord3.setGender("F");
		expectedPersonRecord3.setDateOfBirth("6-3-1975");
		expectedPersonRecord3.setFavoriteColor("Red");

		Assert.assertEquals(expectedPersonRecord, personRecords.get(0));
		Assert.assertEquals(expectedPersonRecord2, personRecords.get(1));
		Assert.assertEquals(expectedPersonRecord3, personRecords.get(2));

	}
}
