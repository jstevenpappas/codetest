package com.codetest.comparator;

import java.text.Collator;
import java.util.Comparator;

import com.codetest.domain.PersonRecord;

public class LastNameComparator implements Comparator<PersonRecord> {
	
	/**
	 * Purpose:
	 * Comparator to allow sorting 
	 * by Last Name, descending.
	 */
	
    private Collator textComparator = Collator.getInstance();

    @Override
	public int compare(PersonRecord o1, PersonRecord o2) {
      PersonRecord c1, c2;
      if ((o1 instanceof PersonRecord) && (o2 instanceof PersonRecord)) {
        c1 = (PersonRecord) o1;
        c2 = (PersonRecord) o2;
        int compareResult = textComparator.compare(c2.getLastName(), c1.getLastName());
       
        return compareResult;
      } else
        return textComparator.compare(o1, o2);
    }

    @Override
	public boolean equals(Object o) {
      return textComparator.equals(o);
    }
  }


