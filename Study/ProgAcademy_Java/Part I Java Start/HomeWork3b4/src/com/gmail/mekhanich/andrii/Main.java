package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
	
	// Число палиндром
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  //declaring scanner

		System.out.println("Please enter your number below:");	//ask user to enter the number

		int a = sc.nextInt(); //declaring variable and take data from user

		int dig1 = a / 100_000;												//declaring the variables split number by digits
		int dig2 = (a % 100_000) / 10_000;
		int dig3 = ((a % 100_000) % 10_000) / 1_000;
		int dig4 = (((a % 100_000) % 10_000) % 1_000) / 100;
		int dig5 = ((((a % 100_000) % 10_000) % 1_000) % 100) / 10;
		int dig6 = ((((a % 100_000) % 10_000) % 1_000) % 100) % 10;
		
		String digit1 = Integer.toString(dig6)+Integer.toString(dig5)+Integer.toString(dig4); //convert digits to string in reverse order
		String digit2 = Integer.toString(dig1)+Integer.toString(dig2)+Integer.toString(dig3); //convert digits to string 
		
		int first = Integer.parseInt(digit1); //convert string to the integer 
		int second = Integer.parseInt(digit2);
		
		System.out.println(first + " "+ second);
		
		if (first == second) {											//compare this two digits
			System.out.println("This number is palindrome");			// return the message if this is palindrome
	} else {															// in other case
			System.out.println("Unfortunately it is not!");				// return this message
		}
		
	}

}
