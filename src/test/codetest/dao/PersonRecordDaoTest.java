package test.codetest.dao;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.codetest.dao.PersonRecordDaoImpl;
import com.codetest.domain.PersonRecord;
import com.codetest.exception.ApplicationException;

public class PersonRecordDaoTest {

	@Test
	public void testGetCSVPersonRecordObject() throws ParseException, ApplicationException{
		String sampleCSVRecord = "Abercrombie, Neil, Male, Tan, 2/13/1943";
				
		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Abercrombie");
		expectedPersonRecord.setFirstName("Neil");
		expectedPersonRecord.setGender("Male");
		expectedPersonRecord.setFavoriteColor("Tan");
		expectedPersonRecord.setDateOfBirth("2/13/1943");
		
		PersonRecordDaoImpl persRecCSVDao = new PersonRecordDaoImpl();
		
		PersonRecord pr = persRecCSVDao.getRecord(sampleCSVRecord, "comma");		
		
		Assert.assertEquals(expectedPersonRecord, pr);
		
	}
	
	@Test
	public void testGetSSVPersonRecordObject() throws ParseException, ApplicationException{
		String sampleSSVRecord = "Kournikova Anna F F 6-3-1975 Red";
		
		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Kournikova");
		expectedPersonRecord.setFirstName("Anna");
		expectedPersonRecord.setMiddleInitial("F");
		expectedPersonRecord.setGender("F");
		expectedPersonRecord.setDateOfBirth("6-3-1975");
		expectedPersonRecord.setFavoriteColor("Red");		
		
		PersonRecordDaoImpl persRecCSVDao = new PersonRecordDaoImpl();
		
		PersonRecord pr = persRecCSVDao.getRecord(sampleSSVRecord, "space");		
		
		Assert.assertEquals(expectedPersonRecord, pr);
		
	}
	
	@Test
	public void testGetPSVPersonRecordObject() throws ParseException, ApplicationException{
		String samplePSVRecord = "Bouillon | Francis | G | M | Blue | 6-3-1975";
		PersonRecord expectedPersonRecord = new PersonRecord();
		expectedPersonRecord.setLastName("Bouillon");
		expectedPersonRecord.setFirstName("Francis");
		expectedPersonRecord.setMiddleInitial("G");
		expectedPersonRecord.setGender("M");		
		expectedPersonRecord.setFavoriteColor("Blue");
		expectedPersonRecord.setDateOfBirth("6-3-1975");
		
		PersonRecordDaoImpl persRecCSVDao = new PersonRecordDaoImpl();
		
		PersonRecord pr = persRecCSVDao.getRecord(samplePSVRecord, "pipe");		
		
		
		Assert.assertEquals(expectedPersonRecord, pr);
		
	}
	

}
