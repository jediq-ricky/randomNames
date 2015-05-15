package com.jediq.randomPeople;

import java.util.*;

public class Person implements Formattable {

	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private String dateOfBirth;

	private Address address = new Address();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMiddleName() {
		return middleName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFieldFromFormat(final char c) {
		switch (c) {
			case 'f': return getFirstName();
			case 'F': return getFirstName().toUpperCase(Locale.getDefault());
			case 'l': return getLastName();
			case 'L': return getLastName().toUpperCase(Locale.getDefault());
			default: return null;
		}
	}
}
