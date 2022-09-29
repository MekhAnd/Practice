package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// Определить следующий элемент последовательности
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your subsequence (separator must be ','):");

		String textSequence = sc.next(); // take sequence and convert into int array
		String[] mainSequence = textSequence.split(",");
		int[] sequence = new int[mainSequence.length];
		for (int i = 0; i < mainSequence.length; i++) {
			sequence[i] = Integer.parseInt(mainSequence[i]);
		}
		System.out.println(Arrays.toString(sequence));

		int compare = sum(sequence); // compare results of method
		if (compare < degreeOf(sequence)) {
			System.out.println("Next element is " + degreeOf(sequence));
		} else if (compare < ofDegree(sequence)) {
			System.out.println("Next element is " + ofDegree(sequence));
		} else if (compare < 0) {
			System.out.println("Unfortunately I can not identify this sequence...");
		} else {
			System.out.println("Next element is " + sum(sequence));
		}
	}

	public static int sum(int[] array) { // method for calculating sequence with sum
		int nextOne = -1;
		int arraySum = (array[array.length - 1] - array[0]);

		if (arraySum % (array.length - 1) == 0) {
			nextOne = array[array.length - 1] + arraySum / (array.length - 1);
		} else {
			nextOne = -1;
		}

		return nextOne;
	}

	public static int degreeOf(int[] array) { // method for calculating sequence when the step is the degree
		int nextOne = -1;
		int arrayBase = 0;

		if (array[array.length - 2] == 0) {
			nextOne = -10000;
		} else {
			arrayBase = (array[array.length - 1]) / (array[array.length - 2]);
			if ((array[array.length - 1]) % (array[array.length - 2]) == 0 && nextOne >= -1) {
				nextOne = (int) Math.pow(arrayBase, array.length);
			}

		}
		return nextOne;
	}

	public static int ofDegree(int[] array) { // method for calculating sequence when the number is the degree of step
		int nextOne = -1;
		
		for (int i = 0; i<=array.length-1; i++) {
			for (int j = 0; j<10; j++) {
				if ()
			}
		}
		
		return nextOne;
	}

	public static int degree(int i, int j) {
		int degree = (int) Math.pow(i, j);
		return degree;
	}
}


