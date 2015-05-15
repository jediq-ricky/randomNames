package com.jediq.randomPeople;

import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Service
public class GeneratorService {

	private List <String> girlsNames;
	private List <String> boysNames;
	private List <String> lastNames;
	private List <String> streetSuffixes;
	private List <String> cityNames;
	private List <String> districtNames;

	private static final int NUM_LETTERS = 26;
	private static final int ASCII_BASE = 65;
	private static final int NUM_HOUSES_IN_STREET = 99;
	private static final int POST_CODE_AREA_SIZE = 98;
	private static final int POST_CODE_LOCATION_SIZE = 9;

	private Random random = new Random();
	private FileHelper fileHelper = new FileHelper();

	public GeneratorService() throws IOException {
		girlsNames = fileHelper.readLinesOfFileFromResource("girlsnames.txt");
		boysNames = fileHelper.readLinesOfFileFromResource("boysnames.txt");
		lastNames = fileHelper.readLinesOfFileFromResource("lastnames.txt");
		streetSuffixes = fileHelper.readLinesOfFileFromResource("streetsuffixes.txt");
		cityNames = fileHelper.readLinesOfFileFromResource("citynames.txt");
		districtNames = fileHelper.readLinesOfFileFromResource("countynames.txt");
	}

	public Person generatePerson() {
		Person person = new Person();		
		person.setGender(random.nextBoolean() ? Gender.MALE : Gender.FEMALE);
		person.setDateOfBirth(generateRandomDateOfBirth());

		person.setFirstName(randomFromList(person.getGender().equals(Gender.FEMALE) ? girlsNames : boysNames));
		person.setMiddleName(randomFromList(person.getGender().equals(Gender.FEMALE) ? girlsNames : boysNames));
		person.setLastName(randomFromList(lastNames));
		
		person.getAddress().setHouseNameOrNumber("" + random.nextInt(NUM_HOUSES_IN_STREET) + 1);
		person.getAddress().setStreetName(randomFromList(lastNames) + " " + randomFromList(streetSuffixes));
		person.getAddress().setCityName(randomFromList(cityNames));
		person.getAddress().setDistrict(randomFromList(districtNames));
		person.getAddress().setZipCode(generateRandomPostCode());

		return person;
	}

	private String generateRandomDateOfBirth() {
		int day = random.nextInt(27)+1;
		int month = random.nextInt(11)+1;
		int year = random.nextInt(100)+1915;
		return day + "/" + month + "/" + year;
	}

	private <T> T randomFromList(final List <T> list) {
		return list.get(random.nextInt(list.size()));
	}

	private String generateRandomPostCode() {
		StringBuilder builder = new StringBuilder();
		builder.append((char)(ASCII_BASE+random.nextInt(NUM_LETTERS)));
		builder.append((char)(ASCII_BASE+random.nextInt(NUM_LETTERS)));
		builder.append(random.nextInt(POST_CODE_AREA_SIZE)+1);
		builder.append(" ");
		builder.append(random.nextInt(POST_CODE_LOCATION_SIZE)+1);
		builder.append((char)(ASCII_BASE+random.nextInt(NUM_LETTERS)));
		builder.append((char)(ASCII_BASE+random.nextInt(NUM_LETTERS)));
		return builder.toString();
	}
	
	
}
