package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	// Получаем номер квартиры, выводим номер подъезда и этаж
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // declaring scanner

		int apNumber = 0; // declaring all variables
		int entrance = 0;
		int floor = 0;

		System.out.println("Please enter appartment number below and press Enter"); // requesting data from user

		apNumber = sc.nextInt(); // take this data

		if (apNumber < 144 && apNumber > 0) { // if user enter wrong apartment
			if (apNumber % 36 == 0) {
				entrance = apNumber / 36;
				floor = 9;
			} else if (apNumber % 4 == 0) {		
				entrance = (apNumber / 36) + 1; 						// calculate the number of entrance
				floor = (apNumber - entrance * 36 + 36) / 4; 			// calculate the floor
			} else {		
				entrance = (apNumber / 36) + 1; 						// calculate the number of entrance
				floor = (apNumber - entrance * 36 + 36) / 4 + 1; 		// calculate the floor
			}
			System.out.println("This apartment situated at entrance number " + entrance + " on the " + floor + "th floor!"); // return answer to the user

		} else {

			System.out.println("There are no apartments with the same number"); // return message to user
			
		}
	}

}
