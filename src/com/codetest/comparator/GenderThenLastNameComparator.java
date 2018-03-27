package com.codetest.comparator;

import java.text.Collator;
import java.util.Comparator;

import com.codetest.domain.PersonRecord;

public class GenderThenLastNameComparator implements Comparator {
	
	/**
	 * Purpose:
	 * Comparator to allow sorting 
	 * by Gender (Female before Male), then Last Name ascending.
	 */
	
	
    private Collator textComparator = Collator.getInstance();
    
    public int compare(Object o1, Object o2) {
      PersonRecord c1, c2;
      if ((o1 instanceof PersonRecord) && (o2 instanceof PersonRecord)) {
        c1 = (PersonRecord) o1;
        c2 = (PersonRecord) o2;
        int compareResult = textComparator.compare(c1.getGender(), c2.getGender());
              
        if (compareResult == 0) {
          compareResult = textComparator.compare(c1.getLastName(), c2.getLastName());
        }
        return compareResult;
      } else
        return textComparator.compare(o1, o2);
    }

    public boolean equals(Object o) {
      return textComparator.equals(o);
    }
  }

