package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

		Integer[] array = new Integer[10];
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(100);
		}
		System.out.println(Arrays.toString(array));

		Predicate<Integer> comp = a -> a < 3;
		
		Predicate<Integer> comp1 = a -> {
			int res = 0;
			for (int j = 1; j < 100; j++) {
				if (a % j == 0) {
					res += 1;
				}
			}
			Boolean result;
			if(res<3) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		};
		

		Function<Integer[], Integer> func = a -> {
			int result = 0;
			for (int i = 0; i < a.length; i++) {
				if (comp1.test(a[i])) {
					result += 1;
				}
			}
			return result;
		};
		System.out.println("In this array - " + func.apply(array) + " simple number");
	}

	public static boolean condition(Integer a, Predicate comp) {
		int res = 0;
		for (int j = 1; j < 100; j++) {
			if (a % j == 0) {
				res += 1;
			}
		}
		return comp.test(res);
	}
}
