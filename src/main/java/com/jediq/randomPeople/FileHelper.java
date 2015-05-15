package com.jediq.randomPeople;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.springframework.core.io.*;

import java.io.*;
import java.util.*;
import java.nio.file.Files;

public final class FileHelper {

	public List<String> readLinesOfFileFromResource(final String resourceName) throws IOException {
		Path path = new ClassPathResource(resourceName).getFile().toPath();
		return Files.readAllLines(path, StandardCharsets.UTF_8);
	}
}
