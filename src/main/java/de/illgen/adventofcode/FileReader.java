package de.illgen.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

	public static String readFile(String name) {
		try (InputStream inputStream = Day1.class.getClassLoader().getResourceAsStream(name);) {
			String data = readFromInputStream(inputStream);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
}
