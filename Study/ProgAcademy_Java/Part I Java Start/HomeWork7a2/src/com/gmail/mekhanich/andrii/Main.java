package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		// Свой вариант метода Arrays.toString для int []

		int [] array = {1,3,5,7,9,2,6,0};
		System.out.println(arraysToString(array));
	}
	
	public static String arraysToString (int []a) {
		StringBuilder sbd = new StringBuilder();
		sbd.append("[");
		for (int i=0; i<=a.length-1; i++) {
			sbd.append(a[i] + ",");
			}
		sbd.append("]");
		
		String textArray = sbd.toString();
		return textArray;
		
	}
	

}
