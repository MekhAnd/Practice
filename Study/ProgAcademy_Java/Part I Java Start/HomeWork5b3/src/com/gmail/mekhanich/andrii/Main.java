package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Выести сумму денег пользователя прописью
		
		Scanner sc = new Scanner(System.in); // declaring the scanner
		System.out.println("Please enter your summ below. You should paste comma between dollars and cents (0,00):"); // ask user to enter the text
		String summ = sc.next(); //take this sum

		String rankOne[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };			//first array for digits between 0 and 9 
		String rankTwo[] = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",		//second array for digits between 10 and 19
				"eighteen", "nineteen" };																			
		String rankThree[] = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",		//third array for decades
				"ninety" };
		//String rankfour[] = { "", "hundred", "thousand", "million" };

		String summ1[] = summ.split(",");		//take string and split it by comma

		int dollars = Integer.parseInt(summ1[0]);		//first element will be dollars
		int cents = Integer.parseInt(summ1[1]);			//second - cents
		// System.out.println(dollars + " " + cents);
		int digitOne = 0;								//declaring three variables for calculating	
		int digitTwo = 0;
		int digitThree = 0;
		

		digitOne = dollars / 1000000;					//calculate first three digits of number
		digitTwo = dollars % 1000000 / 1000;			//calculate second three digits of number
		digitThree = dollars % 1000000 % 1000;			//calculate third three digits of number
		
		if (digitOne >= 100) {															//if the first three digits more than 100 
			int a = digitOne / 100;														//calculating first digit  = place in first array
			if ((digitOne % 100 >= 20 || digitOne % 100 <= 10) && digitOne != 0) {		//understand which rank array it will be true = One and Three
				int b = (digitOne % 100) / 10;											//calculating second digit
				int c = (digitOne % 100) % 10;											//calculating  third digit
				System.out.print("You have: " + rankOne[a] + " hunred " + rankThree[b] + " " + rankOne[c] + " million "); //return first par of message (millions)
			} else {																	//if the last digits of number between 10 and nineteen
				int b = digitOne % 100 - 10;											//calculate place in rankTwo array
				System.out.print("You have: " + rankOne[a] + " hunred " + rankTwo[b] + " million "); //return first par of message (millions)
			}
		} else {
			if ((digitOne % 100 >= 20 || digitOne % 100 <= 10) && digitOne != 0) {		//if the first three digits less than 100 	
				int b = (digitOne % 100) / 10;											//same way 
				int c = (digitOne % 100) % 10;
				System.out.print("You have: " + rankThree[b] + " " + rankOne[c] + " million ");
			} else if (digitOne == 0) {													//if digitOne = 0 (the sum of money less the 1 000 000
				System.out.print("You have: ");											//just return You have
			} else  {
				int b = digitOne % 100 - 10;											//same way
				System.out.print("You have: " + rankTwo[b] + " million ");
			}

		}
		if (digitTwo >= 100) {															//second three digit we calculating the same way lake first
			int a = digitTwo / 100;
			if ((digitTwo % 100 >= 20 || digitTwo % 100 <= 10)&& digitTwo != 0) {
				int b = (digitTwo % 100) / 10;
				int c = (digitTwo % 100) % 10;
				System.out.print(rankOne[a] + " hunred " + rankThree[b] + " " + rankOne[c] + " thousand ");
			} else {
				int b = digitTwo % 100 - 10;
				System.out.print(rankOne[a] + " hunred " + rankTwo[b] + " thousand ");
			}
		} else {
			if ((digitTwo % 100 >= 20 || digitTwo % 100 <= 10)&& digitTwo != 0) {
				int b = (digitTwo % 100) / 10;
				int c = (digitTwo % 100) % 10;
				System.out.print(rankThree[b] + " " + rankOne[c] + " thousand ");
			} else if (digitTwo == 0) {
				System.out.print("");
			} else {
				int b = digitTwo % 100 - 10;
				System.out.print(rankTwo[b] + " thousand ");
			}

		}
		if (digitThree >= 100) {																//third three digit we calculating the same way lake first and second
			int a = digitThree / 100;
			if ((digitThree % 100 >= 20 || digitThree % 100 <= 10)&&digitThree !=0) {
				int b = (digitThree % 100) / 10;
				int c = (digitThree % 100) % 10;
				System.out.print(rankOne[a] + " hunred " + rankThree[b] + " " + rankOne[c] + " dollars ");
			} else {
				int b = digitThree % 100 - 10;
				System.out.print(rankOne[a] + " hunred " + rankTwo[b] + " dollars ");
			}
		} else {
			if ((digitThree % 100 >= 20 || digitThree % 100 <= 10)&&digitThree !=0) {
				int b = (digitThree % 100) / 10;
				int c = (digitThree % 100) % 10;
				System.out.print("and " + rankThree[b] + " " + rankOne[c] + " dollars ");
			} else if (digitThree == 0 && digitTwo == 0 && digitOne == 0) {
				System.out.print("Zero dollars ");
			} else if (digitThree == 0 && (digitTwo != 0 || digitOne != 0)) {
				System.out.print(" dollars ");
			} else {
				int b = digitThree % 100 - 10;
				System.out.print(rankTwo[b] + " dollars ");
			}

		}
		if ((cents>= 20 || cents <= 10) && cents!= 0 ) {											//the same way like dollars but without ranks
			int b = cents / 10;
			int c = cents % 10;
			System.out.print(" and " + rankThree[b] + " " + rankOne[c] + " cents.");
		}  else if (cents == 0) {
			System.out.print("and zero cents.");
		} else {
			int b = cents - 10;
			System.out.print(" and " + rankTwo[b] + " cents.");										//return full sum
		}
		
	} 

}

//one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty
//thirty forty fifty sixty seventy eighty ninety hundred thousand million billion