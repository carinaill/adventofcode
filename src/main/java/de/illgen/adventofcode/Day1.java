package de.illgen.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day1");
		List<String> lines = new ArrayList<>(Arrays.asList(data.split("\r?\n")));

		List<Integer> allcalories = parse(lines);
		List<Integer> caloriesPerElf = sumUp(allcalories);
		caloriesPerElf.sort(Comparator.reverseOrder());

		int mostCalories = part1(caloriesPerElf);
		System.out.println(mostCalories);
		int topThree = part2(caloriesPerElf);
		System.out.println(topThree);
	}

	private static int part1(List<Integer> caloriesPerElf) {
		return caloriesPerElf.get(0);
	}

	private static int part2(List<Integer> caloriesPerElf) {
		int topThree = 0;
		for (int i = 0; i < 3; i++) {
			topThree += caloriesPerElf.get(i);
		}
		return topThree;
	}

	private static List<Integer> sumUp(List<Integer> allcalories) {
		List<Integer> caloriesPerElf = new ArrayList<>();
		int elfsum = 0;
		for (Integer calories : allcalories) {
			if (calories == -1) {
				caloriesPerElf.add(elfsum);
				elfsum = 0;
			} else {
				elfsum += calories;
			}
		}
		return caloriesPerElf;
	}

	private static List<Integer> parse(List<String> data) {
		List<Integer> allCalories = new ArrayList<>();
		for (String line : data) {
			if (line.isBlank()) {
				allCalories.add(-1);
			} else {
				int calories = Integer.parseInt(line);
				allCalories.add(calories);
			}
		}
		allCalories.add(-1);
		return allCalories;
	}
}
