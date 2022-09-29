package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ќаписать код дл€ возможности создани€ массива и код дл€ заполнени€ каждого
		// элемента вручную

		System.out.println("Please enter the array length:");		//ask user to enter array length 
		Scanner sc = new Scanner(System.in);						//declaring scanner
		int length = sc.nextInt();									//take the length
		int arr[] = new int[length];								//declaring array
		for (int i = 0; i < arr.length; i++) {						//start the cycle 
			System.out.println("Please enter number:");				//ask user to enter new array member
			arr[i] = sc.nextInt();									//take this number and save in array
		}
		System.out.println("Your array is - " + Arrays.toString(arr));	//Return the result
	}

}
