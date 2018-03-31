package com.codetest.comparator;

import java.io.Serializable;
import java.util.Comparator;

import com.codetest.domain.PersonRecord;

/**
 * 
 * Purpose: Comparator to allow sorting by Date, ascending.
 * 
 *
 */
public class DateComparator implements Comparator<PersonRecord>, Serializable {
	private static final long serialVersionUID = -2955048582673360405L;
	int compareResult = -1;

	@Override
	public int compare(PersonRecord o1, PersonRecord o2) {
		PersonRecord c1, c2;
		if ((o1 instanceof PersonRecord) && (o2 instanceof PersonRecord)) {
			c1 = (PersonRecord) o1;
			c2 = (PersonRecord) o2;
			compareResult = c1.getDateOfBirth().compareTo(c2.getDateOfBirth());

		}
		return compareResult;
	}

}
