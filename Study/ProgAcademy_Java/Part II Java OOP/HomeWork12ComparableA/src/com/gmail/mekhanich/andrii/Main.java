package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rnd = new Random();
		Rectangle[] array = new Rectangle[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Rectangle(i * rnd.nextInt(10) + 0.5, i * rnd.nextInt(5)+0.5);
		}
		Rectangle z = new Rectangle();
		System.out.println(z.max(array));
		
		Rectangle one = new Rectangle(12, 15);
		Rectangle two = new Rectangle(10, 10);
		Rectangle three = new Rectangle(5, 5);

		Rectangle four = new Rectangle(20, 9);
		
		


		System.out.println("Проверка на корректность реализации Comparable");
		System.out.println(sgn(one.compareTo(two)) == -two.compareTo(one));
		System.out.println((one.compareTo(two) > 0 && two.compareTo(three) > 0) && one.compareTo(three) > 0);
		System.out.println(one.compareTo(four) == 0 && (sgn(one.compareTo(three)) == sgn(two.compareTo(three))));
		System.out.println();
		
		System.out.println("Проверка на согласованность с equals");
		System.out.println(one.equals(four) == true && one.compareTo(four) == 0);
		System.out.println(one.equals(two) == false && one.compareTo(two) != 0);
		System.out.println();
		
		System.out.println(Arrays.toString(array));

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

	}

	public static int sgn(double x) {
		if (x > 0) {
			return 1;
		} else if (x < 0) {
			return -1;
		}
		return 0;
	}

}
