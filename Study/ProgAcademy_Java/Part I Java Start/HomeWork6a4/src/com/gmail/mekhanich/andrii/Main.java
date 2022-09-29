package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод реализующий линейный поиск елемента в массиве

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the array length:");
		int length = sc.nextInt();															
		int[] array = new int[length];																
		for (int i = 0; i < length; i++) {															//creating the array with length from user
			array [i] = (int) (Math.random() * 10);
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Please enter the number what you're looking for:");
		int number = sc.nextInt();
		
		System.out.println(lookingFor(number, array));
		
	}
	public static int lookingFor (int number, int [] array) {										//creating the method which will looks for (like IndexOf() only first index)	
		int index = -1;
		for (int i = 0; i < array.length; i++) {													
		if (number == array [i]) {
			index = i;
			break;
		}
		
		}
		return index;
	}
}
