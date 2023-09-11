package de.illgen.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day1");
		List<String> lines = new ArrayList<>(Arrays.asList(data.split("\r?\n")));
		
		List<Integer> allcalories = parse(lines);
		List<Integer> caloriesPerElf = sumUp(allcalories);
		int mostCalories = findMax(caloriesPerElf);
		
		System.out.println(mostCalories);
	}

	private static int findMax(List<Integer> caloriesPerElf) {
		int max = 0;
		for (Integer calories : caloriesPerElf) {
			if (calories > max) {
				max = calories;
			}
		}
		return max;
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
