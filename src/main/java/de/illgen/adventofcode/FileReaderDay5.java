package de.illgen.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderDay5 {

	public static String readFile1(String name) {
		try (InputStream inputStream = Day5.class.getClassLoader().getResourceAsStream(name);) {
			String data = readFromInputStream1(inputStream);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String readFromInputStream1(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()).contains("[")) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
	
	public static String readFile2(String name) {
		try (InputStream inputStream = Day5.class.getClassLoader().getResourceAsStream(name);) {
			String data = readFromInputStream2(inputStream);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String readFromInputStream2(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine())!= null) {
				if((line).contains("move")) {
				   resultStringBuilder.append(line).append("\n");
				}	
			}
		}
		return resultStringBuilder.toString();
	}
	
}
