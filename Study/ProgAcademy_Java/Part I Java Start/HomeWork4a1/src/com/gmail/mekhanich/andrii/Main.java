package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//С помощью цикла нарисовать обои. Количество полос = число вводимое с клавиатуры
		
		Scanner sc = new Scanner(System.in);   //declaring scanner
		System.out.println("Please enter quantity a bands:"); //ask user to enter number of bands
		
		int bands = sc.nextInt(); 					//declaring variables and take the number of bands
		for (int i = 1; i <=10; i ++) {				//launch the cycle with the rows 
			for (int j = 1; j <= bands; j ++) {		// Drawing + and * in columns with this cycle  
				if (j %2 == 0) {					//if counter even - drawing ***	
					System.out.print("***");
				} else {							// in other case - drawing +++
					System.out.print("+++");
				}
			}
			System.out.println();
		}

	}

}
