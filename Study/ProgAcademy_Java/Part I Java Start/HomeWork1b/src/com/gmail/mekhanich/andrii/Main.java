package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Вычисление и вывод площади треугольника

		Scanner sc = new Scanner(System.in); // declaring scanner 
		
		double side1; // declaring variables
		double side2;
		double side3;
		double area;

		System.out.println("Please enter the length of sides of your triangle, below and press ENTER"); // Ask the user to enter length sides of triangle 

		side1 = sc.nextDouble(); // take length
		side2 = sc.nextDouble();
		side3 = sc.nextDouble();

		double halfPerimeter = (side1 + side2 + side3) / 2;  //declaring and calculating half perimeter
		area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3)); //calculating area

		System.out.println("The area of triangle is: " + area);  //print result

	}

}
