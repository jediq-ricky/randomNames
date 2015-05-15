package com.jediq.randomPeople;

import org.junit.*;

import static org.junit.Assert.*;

public class PersonTest {

	@Test
	public void testGetFieldFromFormat() {
		Person person = new Person();
		person.setFirstName("john");
		person.setLastName("doe");


		assertEquals("john", person.getFieldFromFormat('f'));
		assertEquals("JOHN", person.getFieldFromFormat('F'));
		assertEquals("doe", person.getFieldFromFormat('l'));
		assertEquals("DOE", person.getFieldFromFormat('L'));
		assertNotNull(person.getAddress());
		assertEquals(null, person.getFieldFromFormat('Q'));

	}
	
}
