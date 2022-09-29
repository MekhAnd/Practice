package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
	
	// Високостный год
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  //declaring scanner
		
		System.out.println("Please enter Year below:"); //ask user for data
		
		int year = sc.nextInt();		//take this data and declaring variables
		
		if ((year % 4) == 0 && ((year % 100) != 0 || (year % 400) == 0)) { // if this year divisible without remainder by 4 AND do not divisible without remainder by 
			System.out.println("This year is leap!");	  // 100 OR (but) divisible without remainder by 400 this is leap year = return message to the user  	
		} else {
			System.out.println("It is not leap year!");	 // in any other case - return message					
		}

	}

}
