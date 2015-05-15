package com.jediq.randomPeople;

import java.util.*;

public class Formatter {

	private String format;
	private List <String> tokens;

	public Formatter(final String format) {
		this.format = format;
		tokenise();
	}

	private void tokenise() {
		int pos = 0;
		tokens = new ArrayList <String> ();
		while (pos < format.length()) {
			pos = getTokenFromPosition(pos);
		}
	}

	private int getTokenFromPosition(final int pos) {
		int newPos = pos;
		final String token;
		if (format.charAt(newPos) == '%') {
			if (newPos == format.length()-1 || format.charAt(newPos+1) == '%') {
				token = "%";
				newPos++;
			} else {
				token = "%" + format.charAt(newPos+1);
				newPos+=2;
			}
		} else {
			int end = format.indexOf("%", newPos+1);
			if (end==-1) {
				end = format.length();
			}
			token = format.substring(newPos, end);
			newPos = end;
		}

		tokens.add(token);
		return newPos;
	}

	public String format(final Formattable ... formattables) {
		StringBuilder builder = new StringBuilder();
		for (String token : tokens) {
			if ('%' == token.charAt(0) && token.length() > 1) {
				String s = getFromFormattables(token.charAt(1), formattables);
				builder.append(s != null ? s : token);
			} else {
				builder.append(token);
			}
		}
		return builder.toString();
	}

	private String getFromFormattables(final char c, final Formattable ... formattables) {
		for (Formattable formattable : formattables) {
			String field = formattable.getFieldFromFormat(c);
			if (field != null) {
				return field;
			}
		}
		return null;
	}
}
