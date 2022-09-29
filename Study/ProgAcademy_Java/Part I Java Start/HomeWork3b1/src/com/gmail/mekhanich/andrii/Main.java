package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	//ќпределить принадлежит ли точка окружности
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  //declaring scanner
		System.out.println("Please enter the coordinates of point (x; y)"); //ask user about coordinates
		
		int x = sc.nextInt();  // take this coordinates and declaring the variables
		int y = sc.nextInt();
		
		double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));   //calculating the length of a line segment from point with coordinate (0;0)
		if (radius <= 4) {
			System.out.println("This point belongs to this circle");   // if the coordinates of this point create a line segment less than or equal to the given radius = this point belongs to this circle
		} else {
			System.out.println("This point does not belong to this circle"); // in other case this point does not belongs
		}
		System.out.println(radius);
	}

}
