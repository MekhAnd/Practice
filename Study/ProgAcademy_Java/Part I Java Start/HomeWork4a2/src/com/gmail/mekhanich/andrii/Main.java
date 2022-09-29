package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Вычислить факториал числа

		Scanner sc = new Scanner(System.in); // declaring scanner
		System.out.println("Please choose nubmer (more then 4 and less then 16):"); // ask user to enter number 
		
		int n = sc.nextInt(); 	//take this number and declaring the variable
		long factorial = n;		//declaring the variable for calculating the data
		if (n >= 4 && n <= 16) { // check user input and if  it 4 <= n => 16
			for (int i = n - 1; i >= 1; i--) { //start the cycle
				factorial = factorial * i;      //calculate 
			}
			System.out.println(factorial); //return the answer
		} else {
			System.out.println("Please choose other nubmer (more then 4 and less then 16)"); //if input incorrect return message
		}
		

	}

}
