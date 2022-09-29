package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		// Палиндром полученный умножением двух трехзначных чисел
		
		int maximum = 0;
				
		for (int i = 100; i <=999; i++) {
			for (int j = 100; j<=999; j++) {
				int number = j*i;
				if (palindromeDef(number)) {
					if (maximum < number)
						maximum = number;
					}
				}
		}
		System.out.println("The maximum number is " + maximum + ".");
	}
		
	
	public static boolean palindromeDef(int number) {
		boolean palindrome = false;
		int dig1 = number / 1_000; // declaring the variables split number by digits
		int dig4 = (((number % 100_000) % 10_000) % 1_000) / 100;
		int dig5 = ((((number % 100_000) % 10_000) % 1_000) % 100) / 10;
		int dig6 = ((((number % 100_000) % 10_000) % 1_000) % 100) % 10;

		String digit1 = Integer.toString(dig6) + Integer.toString(dig5) + Integer.toString(dig4); // convert digits to
																									// string in reverse
																									// order

		int first = Integer.parseInt(digit1); // convert string to the integer

		if (first == dig1) { // compare this two digits
			palindrome = true;
		} else { 
			palindrome = false; // return this message
		}
		return palindrome; // return the message if this is palindrome
	}
}
