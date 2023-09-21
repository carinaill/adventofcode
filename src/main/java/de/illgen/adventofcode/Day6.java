package de.illgen.adventofcode;

public class Day6 {

	public static void main(String[] args) {
		String data = FileReader.readFile("day6example1");
		
		int index = findIndex(data, 3);
		System.out.println(index);
		
		int index2 = findIndex(data, 13);
		System.out.println(index2);
	}
	
	private static int findIndex(String data, int last) {
		for (int i = last; i < data.length(); i++) {
			
			if(checkLast(data, i, last)) {
				return i+1;
			}		
		}
		return -1;
	}
	
	public static boolean checkLast(String data, int i, int part) {	
		for(int j = i-part; j<=i; j++) {
			for(int k = j+1; k<=i; k++) {
				if(data.charAt(j)==data.charAt(k)) {
					return false;
				}
			}
		}
		return true;
	}	
} 
