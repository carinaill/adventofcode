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
		
		int sectionsCovered = part1(assignmentList);
		System.out.println(sectionsCovered);

		int sectionsPartlyCovered = part2(assignmentList);
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
	
	private static int part1(List<DataAssignment> assignmentList) {
		int amount = 0;
		for (DataAssignment assignment : assignmentList) {
			
			if ((assignment.getFirstLow() >= assignment.getSecondLow() && assignment.getFirstHigh() <= assignment.getSecondHigh())
					|| (assignment.getSecondLow() >= assignment.getFirstLow() && assignment.getSecondHigh() <= assignment.getFirstHigh())) {
				amount++;
			}
		}
		return amount;
	}
	
	private static int part2(List<DataAssignment> assignmentList) {
		int amount = 0;
		for (DataAssignment assignment : assignmentList) {
			
			if ((assignment.getFirstLow() <= assignment.getSecondHigh() && assignment.getFirstHigh() >= assignment.getSecondLow()) || (assignment.getSecondLow() <= assignment.getFirstHigh() && assignment.getSecondHigh() >= assignment.getFirstLow())) {
				amount++;
			}
		}
		return amount;
	}
}