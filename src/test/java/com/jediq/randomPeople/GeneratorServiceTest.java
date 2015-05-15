package com.jediq.randomPeople;

import org.junit.*;

import static org.junit.Assert.*;

public class GeneratorServiceTest {

	@Test
	public void testGeneratePerson() throws Exception {
		GeneratorService service = new GeneratorService();
		Person person = service.generatePerson();
		assertNotNull(person);
		assertFalse(person.getFirstName().isEmpty());
		assertFalse(person.getMiddleName().isEmpty());
		assertFalse(person.getLastName().isEmpty());
		assertFalse(person.getDateOfBirth().isEmpty());
		assertFalse(person.getGender() == null);
		Integer.parseInt(person.getAddress().getHouseNameOrNumber());
		assertFalse(person.getAddress().getStreetName().isEmpty());
		assertFalse(person.getAddress().getCityName().isEmpty());
		assertFalse(person.getAddress().getDistrict().isEmpty());
		assertFalse(person.getAddress().getZipCode().isEmpty());
	}
}
