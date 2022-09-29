package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	// —частливый билет
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //declaring scanner

		System.out.println("Please enter your number below:"); //ask user to enter number

		int a = sc.nextInt();	//take this number and declaring variables

		int dig1 = a / 1000;						//split the number by signs - first
		int dig2 = (a % 1000) / 100;				//split the number by signs - second
		int dig3 = ((a % 1000) % 100) / 10;			//split the number by signs - third
		int dig4 = ((a % 1000) % 100) % 10;			//split the number by signs - fourth

		if ((dig1 + dig2) == (dig3 + dig4)) {				//check our condition
			System.out.println("YES you are lucky man!!!"); //return message to user
		} else {										// if the sum is not equal
			System.out.println("Try nex ticket(((");  //return this message to user
		}
	}

}
