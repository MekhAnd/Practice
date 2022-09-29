package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Нарисовать прямоугольник из "*" на основе вводимых пользователем значений
		
		Scanner sc = new Scanner(System.in); // declaring scanner
		System.out.println("Please enter widght and hight:"); // ask user to enter width and height

		int widht = sc.nextInt(); // declaring variables and take the number of columns
		int height = sc.nextInt(); // declaring variables and take the number of rows

		for (int i = 1; i <= height; i++) {								//start the cycle for rows
			for (int j = 1; j <= widht; j++) {							//start the cycle for columns	
				if (i ==1 || j == 1 || j == widht || i == height) {		// if this is first or last rows or if this first o last sign in column 
					System.out.print("*");								// print *
				} else {												// in other case - print space
					System.out.print(" ");
				}
				
			}
			System.out.println();										//creating new row after iteration
		}
	}

}
