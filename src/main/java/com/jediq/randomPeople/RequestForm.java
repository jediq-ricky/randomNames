package com.jediq.randomPeople;

public class RequestForm {

	private String numberOfPeople = "50";
	private String format = "%L, %f. %n, %s, %c, %d, %z";

	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(final String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(final String format) {
		this.format = format;
	}
}
