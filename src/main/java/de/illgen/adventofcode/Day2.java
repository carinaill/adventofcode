package de.illgen.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day2");
		List<String> lines = new ArrayList<>(Arrays.asList(data.split("\r?\n")));

		int sum = part1(lines);
		System.out.println(sum);

		int sumPart2 = part2(lines);
		System.out.println(sumPart2);
	}

	private static int part1(List<String> lines) {
		int sum = 0;
		for (String line : lines) {
			sum += roundPart1(line);

		}
		return sum;
	}

	private static int roundPart1(String line) {
		if (line.charAt(0) == 'A') {
			return getPointsA(line);
		} else if (line.charAt(0) == 'B') {
			return getPointsB(line);
		} else if (line.charAt(0) == 'C') {
			return getPointsC(line);
		}
		throw new IllegalStateException();
	}

	private static int part2(List<String> lines) {
		int sum = 0;
		for (String line : lines) {
			sum += roundPart2(line);

		}
		return sum;
	}

	private static int roundPart2(String line) {
		if (line.charAt(2) == 'X') {
			return getPointsX(line);
		} else if (line.charAt(2) == 'Y') {
			return getPointsY(line);
		} else if (line.charAt(2) == 'Z') {
			return getPointsZ(line);
		}
		throw new IllegalStateException();
	}

	private static int getPointsC(String line) {
		switch (line.charAt(2)) {
			case ('X'):
				return 7;
			case ('Y'):
				return 2;
			case ('Z'):
				return 6;
			default:
				throw new IllegalStateException();
		}
	}

	private static int getPointsB(String line) {
		switch (line.charAt(2)) {
			case ('X'):
				return 1;
			case ('Y'):
				return 5;
			case ('Z'):
				return 9;
			default:
				throw new IllegalStateException();
		}
	}

	private static int getPointsA(String line) {
		switch (line.charAt(2)) {
			case ('X'):
				return 4;
			case ('Y'):
				return 8;
			case ('Z'):
				return 3;
			default:
				throw new IllegalStateException();
		}
	}

	private static int getPointsZ(String line) {
		switch (line.charAt(0)) {
			case ('A'):
				return 8;
			case ('B'):
				return 9;
			case ('C'):
				return 7;
			default:
				throw new IllegalStateException();
		}
	}

	private static int getPointsY(String line) {
		switch (line.charAt(0)) {
			case ('A'):
				return 4;
			case ('B'):
				return 5;
			case ('C'):
				return 6;
			default:
				throw new IllegalStateException();
		}
	}

	private static int getPointsX(String line) {
		switch (line.charAt(0)) {
			case ('A'):
				return 3;
			case ('B'):
				return 1;
			case ('C'):
				return 2;
			default:
				throw new IllegalStateException();
		}
	}
}
