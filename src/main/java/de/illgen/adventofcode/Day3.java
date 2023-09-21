package de.illgen.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day3");
		List<String> lines = new ArrayList<>(Arrays.asList(data.split("\r?\n")));

		int sumOfPriorities = part1(lines);
		System.out.println(sumOfPriorities);

		int sumOfPriorities2 = part2(lines);
		System.out.println(sumOfPriorities2);
	}

	private static int part1(List<String> lines) {
		int sumOfPriorities = 0;
		for (String line : lines) {
			int mid = line.length() / 2;
			String[] partsRucksack = { line.substring(0, mid), line.substring(mid) };

			String mistake = findMistake(partsRucksack[0], partsRucksack[1]);
			int priority = convertToPriority(mistake.charAt(0));
			sumOfPriorities += priority;
		}
		return sumOfPriorities;
	}

	private static int part2(List<String> lines) {
		int sumOfPriorities = 0;
		for(int i = 0; i<lines.size(); i= i+3) {
			String commonChars = findMistake(lines.get(i), lines.get(i+1));
			String mistake = findMistake(commonChars, lines.get(i+2));
			int priority = convertToPriority(mistake.charAt(0));
			sumOfPriorities += priority;
		}
		return sumOfPriorities;
	}

	private static int convertToPriority(int mistake) {
		if (mistake >= 'a') {
			return mistake - 'a' + 1;
		} else {
			return mistake - 'A' + 26 + 1;
		}
	}

	private static String findMistake(String string1, String string2) {
		StringBuilder mistakes = new StringBuilder();
		for (int i = 0; i < string2.length(); i++) {
			for (int j = 0; j < string1.length(); j++) {
				if (string2.charAt(i) == string1.charAt(j)) {
					mistakes.append(string2.charAt(i));
				}
			}
		}
		return mistakes.toString();
	}

}
