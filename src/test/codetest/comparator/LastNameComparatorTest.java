package test.codetest.comparator;

import static org.junit.Assert.*;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.codetest.comparator.DateComparator;
import com.codetest.comparator.LastNameComparator;
import com.codetest.domain.PersonRecord;
import com.codetest.domain.PersonRecordDataSource;
import com.codetest.exception.PersonRecordException;
import com.codetest.service.PersonRecordService;
import com.codetest.service.PersonRecordServiceImpl;

public class LastNameComparatorTest {
	
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
	public void testCompare() throws PersonRecordException, ParseException {
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
		expectedPersonRecord.setLastName("Bishop");
		expectedPersonRecord.setFirstName("Timothy");
		expectedPersonRecord.setGender("Male");
		expectedPersonRecord.setDateOfBirth("4/23/1967");
		expectedPersonRecord.setFavoriteColor("Yellow");
		
		Assert.assertEquals(expectedPersonRecord, personRecords.get(7));
	}

}
