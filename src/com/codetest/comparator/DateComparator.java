package com.codetest.comparator;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.codetest.domain.PersonRecord;

/**
 * 
 * Purpose:
 * Comparator to allow sorting 
 * by Date, ascending.
 * 
 *
 */
public class DateComparator implements Comparator, Serializable {
	int compareResult = -1;
    public int compare(Object o1, Object o2) {
      PersonRecord c1, c2;
      if ((o1 instanceof PersonRecord) && (o2 instanceof PersonRecord)) {
        c1 = (PersonRecord) o1;
        c2 = (PersonRecord) o2;
        compareResult = c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
               
      } 
      return compareResult;
    }
    
  }
