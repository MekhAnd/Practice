package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Реализовать метод который рисует прямоугольник из *

		Scanner sc = new Scanner(System.in); // declaring scanner
		System.out.println("Please enter widght and hight:"); // ask user to enter width and height

		int a = sc.nextInt(); // declaring variables and take the number of columns
		int b = sc.nextInt(); // declaring variables and take the number of rows
		rectangleDraw(a, b);
	}

	public static void rectangleDraw(int a, int b) {		//creating method which draw rectangle

		//String array[][] = new String[a][b];
		for (int i = 0; i <= a - 1; i++) {
			for (int j = 0; j <= b - 1; j++) {
				if (i == 0 || j == 0 || i == a - 1 || j == b - 1) {
					//array[i][j] = "*";
					System.out.print("*");
				} else {
					//array[i][j] = " ";
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
