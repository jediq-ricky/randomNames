package com.jediq.randomPeople;

import org.junit.*;

import static org.junit.Assert.*;

public class FormatterTest {

	@Test
	public void testFormat() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%b%c");
		assertEquals("ABC", formatter.format(formattable));
	}

	@Test
	public void testFormat_TrailingPercent() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%b%c%");
		assertEquals("ABC%", formatter.format(formattable));
	}

	@Test
	public void testFormat_UnknownToken() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%b%c%d");
		assertEquals("ABC%d", formatter.format(formattable));
	}

	@Test
	public void testFormat_DoublePercent() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%%b%c");
		assertEquals("A%BC", formatter.format(formattable));
	}

	@Test
	public void testFormat_prefixText() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("123%a%b%c");
		assertEquals("123ABC", formatter.format(formattable));
	}

	@Test
	public void testFormat_suffixText() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%b%c123");
		assertEquals("ABC123", formatter.format(formattable));
	}

	@Test
	public void testFormat_percentageInText() {
		Formattable formattable = createFormattable();
		Formatter formatter = new Formatter("%a%b34.8% %c");
		assertEquals("AB34.8% C", formatter.format(formattable));
	}


	private Formattable createFormattable() {
		return new Formattable() {
			public String getFieldFromFormat(final char c) {
				switch(c) {
					case 'a': return "A";
					case 'b': return "B";
					case 'c': return "C";
					default: return null;
				}
			}
		};
	}
}
