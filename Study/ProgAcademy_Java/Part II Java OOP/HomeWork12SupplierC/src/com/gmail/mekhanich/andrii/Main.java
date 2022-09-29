package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		int length = 10;
		Integer[] array = new Integer[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = (Integer)rnd.nextInt(10);
			}
		System.out.println(Arrays.toString(array));

		BiFunction<Integer[], Integer, Integer> bfun = Main::newPosition;
		for (int i = 0; i < length; i++) {
			System.out.println(bfun.apply(array, i));
		}
	}
	
	public static int newPosition(Integer [] array, Integer a) {
		IntSupplier inSup = () -> array[a];
		return inSup.getAsInt();
	}
}
