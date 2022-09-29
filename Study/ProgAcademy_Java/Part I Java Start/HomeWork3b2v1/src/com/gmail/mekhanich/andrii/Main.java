package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // declaring scanner
		System.out.println("Please enter the coordinates of point (x; y)"); // ask user about coordinate

		double x = sc.nextDouble(); // take this coordinate and declaring variables
		double y = sc.nextDouble();

		double sectionOne = (x - 0) * (4 - 0) - (y - 0) * (4 - 0); 
		double sectionTwo = (x - 4) * (1 - 4) - (y - 4) * (6 - 4);
		double sectionThree = (x - 6) * (0 - 1) - (y - 1) * (0 - 6);

		if ((sectionOne <= 0 && sectionTwo <= 0 && sectionThree <= 0) ||(sectionOne >= 0 && sectionTwo >= 0 && sectionThree >= 0)) {
			System.out.println("This point belongs to this triangle");
		} else {
			System.out.println("This point in not belongs to this triangle");
		}

	}

}
