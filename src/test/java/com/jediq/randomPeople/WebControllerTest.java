package com.jediq.randomPeople;

import java.util.List;
import org.junit.*;

import junitx.util.PrivateAccessor;
import org.springframework.ui.*;

import java.io.*;

import static org.junit.Assert.*;

public class WebControllerTest {

	@Test
	public void testGet() throws Exception {
		WebController wc = new WebController();
		List<Person> response = wc.getHandler(2000);
		assertFalse(response.isEmpty());
		assertEquals(2000, response.size());
	}

}
