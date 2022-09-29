package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод который возвращает конкатенацию строки с суммой вещественного и целого чисел
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your data. First of all you should input text:");
		String text = sc.nextLine();
		System.out.println("Please enter whole numeric value:");
		int firstValue = sc.nextInt();
		System.out.println("Please enter real numeric value:");
		double secondValue = sc.nextDouble();
		
		System.out.println(sumOfParts(text, firstValue, secondValue));
	}
	public static String sumOfParts (String a, int b, double c) {				//create the method for concatenations
		double value = b+c;
		String sum = a + " " + value;
		return sum;
	}
}
