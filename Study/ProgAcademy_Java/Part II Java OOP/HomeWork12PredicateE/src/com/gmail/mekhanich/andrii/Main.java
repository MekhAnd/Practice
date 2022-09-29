package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntPredicate;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();

		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " " + even(array[i], a -> a % 2 == 0));
		}

	}

	public static boolean even(int arNum, IntPredicate inPr) {
		int number = 0;
		int temp = arNum;
		if(arNum<10) {
			number += arNum;
		} else {
			number += temp % 10;
			number += temp / 10;
		}
		return inPr.test(number);
	}
}
