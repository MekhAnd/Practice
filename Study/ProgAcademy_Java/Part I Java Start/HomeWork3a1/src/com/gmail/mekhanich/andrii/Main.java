package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
	// Ќаписать программу котора€ считае 4 числа с клавиатуры и выведет максимум
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // declaring scanner

		int a;  // declaring all variables
		int b;
		int c;
		int d;
		int max;  // declaring variable for maximum digit

		System.out.println("Please enter your nuber below and press ENTER:");

		a = sc.nextInt();  //take values of variables
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		max = a;			// take that the first digit is the maximum digit
		if (max < b) {		//compare this digit with next
			max = b;		//if next one is less than pass its value to the variable max
		}
		if (max < c) {		//compare this digit with next
			max = c;		//if next one is less than pass its value to the variable max
		}
		if (max < d) {		//compare this digit with next
			max = d;		//if next one is less than pass its value to the variable max
		}

		System.out.println(max); // return the value of variable max to user
	}

}
