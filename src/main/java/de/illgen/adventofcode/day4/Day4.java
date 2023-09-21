package de.illgen.adventofcode.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.illgen.adventofcode.FileReader;

public class Day4 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day4");
		List<String> lines = new ArrayList<>(Arrays.asList(data.split("\r?\n")));
		List<DataAssignment> assignmentList = getAssignmentList(lines);
		
		int sectionsCovered = part1Improved(assignmentList);
		System.out.println(sectionsCovered);

		int sectionsPartlyCovered = part2Improved(assignmentList);
		System.out.println(sectionsPartlyCovered);

	}
	private static List<DataAssignment> getAssignmentList(List<String> lines){
		List<DataAssignment> assignmentList = new ArrayList<>();
		for (String line : lines) {
			String[] sections = line.split("[,-]");
			int firstLow = Integer.parseInt(sections[0]);
			int firstHigh = Integer.parseInt(sections[1]);
			int secondLow = Integer.parseInt(sections[2]);
			int secondHigh = Integer.parseInt(sections[3]);
			DataAssignment assignment = new DataAssignment(firstLow, firstHigh, secondLow, secondHigh);
			assignmentList.add(assignment);
		}
		return assignmentList;
		
	}
	
	private static int part1Improved(List<DataAssignment> assignmentList) {
		int amount = 0;
		for (DataAssignment assignment : assignmentList) {
			
			if ((assignment.getFirstLow() >= assignment.getSecondLow() && assignment.getFirstHigh() <= assignment.getSecondHigh())
					|| (assignment.getSecondLow() >= assignment.getFirstLow() && assignment.getSecondHigh() <= assignment.getFirstHigh())) {
				amount++;
			}
		}
		return amount;
	}
	
	private static int part2Improved(List<DataAssignment> assignmentList) {
		int amount = 0;
		for (DataAssignment assignment : assignmentList) {
			
			if ((assignment.getFirstLow() <= assignment.getSecondHigh() && assignment.getFirstHigh() >= assignment.getSecondLow()) || (assignment.getSecondLow() <= assignment.getFirstHigh() && assignment.getSecondHigh() >= assignment.getFirstLow())) {
				amount++;
			}
		}
		return amount;
	}

	
	
	//
	private static int part1(List<String> lines) {
		int amount = 0;
		for (String line : lines) {
			String[] sections = line.split(",");
			Integer[] seprateSections1 = writeSectionArray(sections, 0);
			Integer[] seprateSections2 = writeSectionArray(sections, 1);
			if (condition1(seprateSections1, seprateSections2)) {
				amount++;
			}
		}
		return amount;
	}

	private static int part2(List<String> lines) {
		int amount = 0;
		for (String line : lines) {
			String[] sections = line.split(",");
			Integer[] seprateSections1 = writeSectionArray(sections, 0);
			Integer[] seprateSections2 = writeSectionArray(sections, 1);
			if (condition2(seprateSections1, seprateSections2)) {
				amount++;
			}
		}
		return amount;
	}

	private static boolean condition1(Integer[] seprateSections1, Integer[] seprateSections2) {
		if (Arrays.asList(seprateSections1).containsAll(Arrays.asList(seprateSections2))
				|| Arrays.asList(seprateSections2).containsAll(Arrays.asList(seprateSections1))) {
			return true;
		}
		return false;
	}

	private static boolean condition2(Integer[] seprateSections1, Integer[] seprateSections2) {
		for (Integer sectionI : seprateSections2) {
			if (Arrays.asList(seprateSections1).contains(sectionI)) {
				return true;
			}
		}
		return false;
	}

	private static Integer[] writeSectionArray(String[] sections, int index) {
		String[] singleSection = sections[index].split("-");
		int length = Integer.parseInt(singleSection[1]) - Integer.parseInt(singleSection[0]) + 1;
		Integer[] seprateSections = new Integer[length];

		for (int i = 0; i < seprateSections.length; i++) {
			seprateSections[i] = Integer.parseInt(singleSection[0]) + i;
		}
		return seprateSections;
	}
}
