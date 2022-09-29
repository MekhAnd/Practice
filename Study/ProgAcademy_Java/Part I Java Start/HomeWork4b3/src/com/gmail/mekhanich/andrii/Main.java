package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Нарисовать песочные часы - высота/ширина вводится с клавиатуры
		
		Scanner sc = new Scanner(System.in);											//declaring scanner
		System.out.println("Please enter your number, the number should be an odd:");	//ask user to enter height

		int parametr = sc.nextInt();													//take this data

		if (parametr % 2 == 0) {														//if parametr is not the odd
			System.out.println("Please enter an odd number!");							//ask user to enter right numder
		} else {
			int mediana = parametr / 2 + 1;												//calculating the center line of the figure
			//int count = 0;

			for (int i = 1; i <= parametr; i++) {										//start outer loop which draw rows
				for (int j = 1; j <= parametr; j++) {									//start inner loop which draw columns
					if (i == 1) {														// if this is first row 
						System.out.print("*");											//- draw *
					} else if (i > 1 && (j <= i - 1 || j > parametr - (i - 1)) && i <= mediana) { //if this is not first AND i less than mediana row AND number of column less than number of row by 1 OR bigger than (parametr - i - 1) 
						System.out.print(" ");											//- draw " "
					} else if (i > 1 && (j <= parametr - i  || j > i ) && i > mediana){ //if this is not first AND i bigger than mediana rows AND number of column bigger than number of row OR less than (parametr - i) 
						System.out.print(" "); 											//- draw " "
					} else if (i == parametr) {											// if this is last row 
						System.out.print("*");											//- draw *
					} else {															// all other case draw *
						System.out.print("*");
					}
				}
				
				//else if (i > 1 && (j <= parametr - (i - 1) || j > i - 1) && i > mediana){
				//	System.out.print(" ");
				/*}*/
				
				/*for (int k = parametr; k >= 0; k--) {
					if (i == parametr) {
						System.out.print("*");
					} else if (k <= parametr - i || k > i - 1) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}*/

				System.out.println();

			}

		}
	}
}
