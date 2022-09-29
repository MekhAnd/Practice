package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// С помощью одного цикла нарисовать пирамиду (высота вводится с клавиатуры)

		Scanner sc = new Scanner(System.in); // declaring scanner
		System.out.println("Please enter the height of figure:"); // ask user to enter height
		int height = sc.nextInt(); // take this data
		int sw1 = 1; // declaring variable (switcher1) which power on our cycle
		int sw2 = 0; // declaring variable (switcher2) which on/off draw * and change line
		int sw3 = 1; // declaring variable (switcher3) which calculating lines and off our cycle
		// int sw4 = height;

		while (sw1 > 0) { // launch cycle
			System.out.print("*"); // draw *
			sw2++; // count this drawing
			if (sw3 == sw2) { // if quantity of * equal to switcher2
				// System.out.println("ZASHIOL");
				System.out.println(); // change the line
				sw2 = 0; // reset the value of switcher2
				sw1 += 1; // count the line
				// System.out.println(sw1 + ", " + sw3 + ", " + sw4);

				if (sw1 >= height + 1) { // when switcher1 will be equal to height of our figure
					sw3--; // reduce the value of swither3
					if (sw3 == 0) { // when switcher1 will be equal to 0
						break; // break our cycle
					}
				} else { // when switcher3 less than the height of our figure
					sw3++; // increase value of switcher3
				}

			}

		}
	}
}

/*
 * while (sw1 != 0) { if (sw1 > sw2) { System.out.print("*"); sw2++; } else {
 * System.out.println(); sw2 = 0; if (sw1 == height) { sw3 = -1; } sw1 += sw3; }
 * }
 */

/*
 * String line = ""; variant 1 String a = "*"; variant 1 String b = " "; variant
 * 1 String line2 = ""; variant 1
 */
/*
 * int count = 0; variant 2 int z = 0; variant 2
 * 
 * 
 * while (z <= heighr*2) { variant 2 z++; variant 2 int a = 0; variant 2
 * 
 * if (z<=heighr) { variant 2 count++; variant 2 if (a <= z) { variant 2
 * System.out.print("*"); variant 2 a++; variant 2 } else { variant 2
 * System.out.println(); variant 2 variant 2 } variant 2 }
 * System.out.println(z); variant 2
 * 
 * } variant 2
 */

/*
 * for (int i = 1; i <= heighr*2; i++) { variant 1 count ++; variant 1 if (i <=
 * heighr) { variant 1 count++; variant 1 line = line + a; variant 1
 * System.out.println(line,i); variant 1 } else if (i >= heighr) { variant 1
 * 
 * System.out.println(line); variant 1 } variant 1 } variant 1
 */
