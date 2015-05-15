package com.jediq.randomPeople;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AddressTest {


	@Test
	public void testGetFieldFromFormat() {
		Address address = new Address();
		address.setHouseNameOrNumber("45");
		address.setStreetName("banana road");
		address.setCityName("Hull");
		address.setDistrict("Yorkshire");
		address.setZipCode("HU12 0QQ");

		assertEquals("45", address.getFieldFromFormat('n'));
		assertEquals("banana road", address.getFieldFromFormat('s'));
		assertEquals("BANANA ROAD", address.getFieldFromFormat('S'));
		assertEquals("Hull", address.getFieldFromFormat('c'));
		assertEquals("HULL", address.getFieldFromFormat('C'));
		assertEquals("Yorkshire", address.getFieldFromFormat('d'));
		assertEquals("YORKSHIRE", address.getFieldFromFormat('D'));
		assertEquals("HU12 0QQ", address.getFieldFromFormat('z'));
		assertEquals(null, address.getFieldFromFormat('Q'));
	}
}
