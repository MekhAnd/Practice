package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ¬ычисление и вывод длинны окружности

		Scanner sc = new Scanner(System.in); // declaring scanner

		double circleLength;
		double radius;

		System.out.println("Please enter radius below and press ENTER"); // Ask the user to enter radius 
		radius = sc.nextDouble();	// take radius
		circleLength = 2 * Math.PI * radius;  //calculating circumference

		System.out.println("The circumference is: " + circleLength); //print result

	}

}
