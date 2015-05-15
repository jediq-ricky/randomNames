package com.jediq.randomPeople;

import java.util.*;

public class Address implements Formattable {

	private String houseNameOrNumber;
	private String streetName;
	private String district;
	private String cityName;
	private String zipCode;


	public String getHouseNameOrNumber() {
		return houseNameOrNumber;
	}

	public void setHouseNameOrNumber(final String houseNameOrNumber) {
		this.houseNameOrNumber = houseNameOrNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(final String streetName) {
		this.streetName = streetName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(final String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(final String cityName) {
		this.cityName = cityName;
	}

	public String getFieldFromFormat(final char c) {
		switch (c) {
			case 'n': return getHouseNameOrNumber();
			case 's': return getStreetName();
			case 'S': return getStreetName().toUpperCase(Locale.getDefault());
			case 'c': return getCityName();
			case 'C': return getCityName().toUpperCase(Locale.getDefault());
			case 'd': return getDistrict();
			case 'D': return getDistrict().toUpperCase(Locale.getDefault());
			case 'z': return getZipCode();
			default: return null;
		}
	}
}
