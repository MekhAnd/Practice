package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
		// Метод который возвращает максимальное число из массива
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the array length:");
		int arrLength = sc.nextInt();
		int [] arr = createArray(arrLength);								// save the array which we created with createArray method
	int max = maximumNumber(arr);											// return the maximum value
		System.out.println("Yor array is " + Arrays.toString(arr));
		System.out.println("The maximum number in your array is - "+ max);

	}

	public static int[] createArray(int arrLength) {						//create the method for generating array with Math Random
		int arr[] = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = (int) (1-Math.random() * 10);

		}
		return arr;
	}

	public static int maximumNumber(int[] arr) {						// create the method for calculating maximum value
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
					max = arr[i];
			}
			
		}
		return max;
	}

}
