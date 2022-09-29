package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Написать программу, которая считывает 5 значное число с клавиатуры и выводит цифры из которого оно состоит. 
		
		int firstNumber; // declaring all variables
		int digit1;
		int digit2;
		int digit3;
		int digit4;
		int digit5;
		int a;

		Scanner sc = new Scanner(System.in); // declaring scanner

		System.out.println("Please enter your 5 digit number below and press ENTER:"); // Ask the user to enter number
		firstNumber = sc.nextInt(); // take the number

		digit1 = firstNumber / 10000; // calculating first digit
		System.out.println(digit1); // print first digit

		a = firstNumber % 10000; // calculating intermediate value
		
		digit2 = a / 1000;  // calculating second digit
		System.out.println(digit2);  // print second digit

		a = a % 1000; // calculating next intermediate value
				
		digit3 = a / 100; // calculating third digit
		System.out.println(digit3); // print third digit
		
		a = a % 100; // calculating next intermediate value
				
		digit4 = a / 10; // calculating fourth digit
		System.out.println(digit4); // print fourth digit
		
		digit5 = a % 10; // calculating last digit
		System.out.println(digit5); //print last digit
		
	}

}
