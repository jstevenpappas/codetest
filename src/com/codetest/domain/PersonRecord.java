package com.codetest.domain;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Domain Object representing Person Record
 * 
 */
public class PersonRecord {
	
	private String lastName;
	private String firstName;
	private String middleInitial;
	private String gender;
	private String favoriteColor;
	private Date dateOfBirth;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("M")){
			this.gender = "Male";
		} else if(gender.equalsIgnoreCase("F")){
			this.gender = "Female";
		} else {
			this.gender = gender;
		}
		
	}
	public String getFavoriteColor() {
		return favoriteColor;
	}
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		/*
		 * 2 formats accepted,
		 * one returned
		 */
		if(dateOfBirth.trim().matches("\\d{1,2}-\\d{1,2}-\\d{4,4}")){
			//reformat it accordingly
			this.dateOfBirth = new SimpleDateFormat("M-d-yyyy").parse(dateOfBirth);
			
		} else {
			//just set it as it
			this.dateOfBirth = new SimpleDateFormat("M/d/yyyy").parse(dateOfBirth);
		} 
	}
	@Override
	public String toString() {
		/*
		 * Example toString() default
		 * output:
		 * (lastName,firstName,gender,date,color)
		 * Abercrombie Neil Male 2/13/1943 Tan
		 */
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		return lastName + " " + firstName + " "	+ gender + " " + format.format(dateOfBirth) + " " + favoriteColor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((favoriteColor == null) ? 0 : favoriteColor.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleInitial == null) ? 0 : middleInitial.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonRecord other = (PersonRecord) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (favoriteColor == null) {
			if (other.favoriteColor != null)
				return false;
		} else if (!favoriteColor.equals(other.favoriteColor))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		return true;
	}
	
	
	
	

}
