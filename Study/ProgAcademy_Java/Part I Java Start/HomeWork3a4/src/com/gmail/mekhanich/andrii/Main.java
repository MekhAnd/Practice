package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
	
	// Треугольник, сумма 2 сторон всегда больше третей
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //declaring scanner

		System.out.println("Please enter the sides of triangle below:"); //ask user to enter data

		double a = sc.nextDouble(); // take this data and declaring the variables
		double b = sc.nextDouble();
		double c = sc.nextDouble();

		if ((a + b) >= c && (a + c) >= b && (b + c) >= a) { // if the sum of length of 2 sides is longer then third side  
			System.out.println("This is triangle.");		// return message to the user
		} else {
			System.out.println("This is not triangle.");    // in any other case return this message
		}

	}

}
