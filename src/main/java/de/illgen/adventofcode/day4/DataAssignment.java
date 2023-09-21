package de.illgen.adventofcode.day4;

public class DataAssignment {

	private int firstLow;
	private int firstHigh;
	private int secondLow;
	private int secondHigh;
	
	public DataAssignment(int firstLow, int firstHigh, int secondLow, int secondHigh) {
		this.firstLow = firstLow;
		this.firstHigh= firstHigh;
		this.secondLow = secondLow;
		this.secondHigh = secondHigh;
	}
	
	public int getFirstLow() {
		return firstLow;
	}
	public void setFirstLow(int firstLow) {
		this.firstLow = firstLow;
	}
	public int getFirstHigh() {
		return firstHigh;
	}
	public void setFirstHigh(int firstHigh) {
		this.firstHigh = firstHigh;
	}
	public int getSecondLow() {
		return secondLow;
	}
	public void setSecondLow(int secondLow) {
		this.secondLow = secondLow;
	}
	public int getSecondHigh() {
		return secondHigh;
	}
	public void setSecondHigh(int secondHigh) {
		this.secondHigh = secondHigh;
	}
}
