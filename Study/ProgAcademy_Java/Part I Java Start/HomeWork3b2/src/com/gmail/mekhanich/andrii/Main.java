package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  		//declaring scanner
		System.out.println("Please enter the coordinates of point (x; y)"); //ask user about coordinate

		double x = sc.nextDouble(); //take this coordinate and declaring variables
		double y = sc.nextDouble();
		
		double sideA = Math.sqrt(Math.pow((4 - 0), 2) + Math.pow((4 - 0), 2));  //calculating the length of sides 
		double sideB = Math.sqrt(Math.pow((6 - 4), 2) + Math.pow((1 - 4), 2));
		double sideC = Math.sqrt(Math.pow((0 - 6), 2) + Math.pow((0 - 1), 2));
		
		double halfPerimeter = (sideA + sideB + sideC) / 2;  //declaring and calculating half perimeter
		double areaMain = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC)); //calculating area of Main triangle
		
		double sideA1 = Math.sqrt(Math.pow((x - 4), 2) + Math.pow((y - 4), 2));		//calculating the length of sides of new (first) triangle which we build with coordinates from user 
		double sideA2 = Math.sqrt(Math.pow((0 - x), 2) + Math.pow((0 - y), 2));
		double halfPerimeter1 = (sideA + sideA1 + sideA2) / 2;  					//declaring and calculating half perimeter for first triangle
		double area1 = Math.sqrt(halfPerimeter1 * (halfPerimeter1 - sideA) * (halfPerimeter1 - sideA1) * (halfPerimeter1 - sideA2)); //calculating area for first triangle
		
		double sideB1 = sideA1;													// one side of first triangle
		double sideB2 = Math.sqrt(Math.pow((x - 6), 2) + Math.pow((y - 1), 2)); //calculating the length of sides of new (second) triangle which we build with coordinates from user
		double halfPerimeter2 = (sideB + sideB1 + sideB2) / 2;  //declaring and calculating half perimeter for first triangle
		double area2 = Math.sqrt(halfPerimeter2 * (halfPerimeter2 - sideB) * (halfPerimeter2 - sideB1) * (halfPerimeter2 - sideB2)); //calculating area for second triangle
		
		double halfPerimeter3 = (sideC + sideA2 + sideB2) / 2;  //declaring and calculating half perimeter for first triangle
		double area3 = Math.sqrt(halfPerimeter3 * (halfPerimeter3 - sideC) * (halfPerimeter3 - sideA2) * (halfPerimeter3 - sideB2)); //calculating area for second triangle

		double areaSecondary = Math.round((area1 + area2 + area3));  //round our value 
		
		if (areaMain == areaSecondary) {									// compare all lengths if all lengths are smaller or equal
			System.out.println("This point belongs to this triangle");				// return this message
		} else {																	//in other case	
			System.out.println("This point does not belong to this triangle");		// return this message
		}

	}
}
