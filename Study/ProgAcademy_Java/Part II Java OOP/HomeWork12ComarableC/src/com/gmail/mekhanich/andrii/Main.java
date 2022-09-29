package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Cat a = new Cat("Umka First", 12);
		Cat b = new Cat("Luska Sec", 5);
		Cat c = new Cat("Kuzia", 2);
		Cat d = new Cat("Umka First", 11);
		Cat e = new Cat("Barsic", 12);

		Cat[] cats = new Cat[] { a, b, c, d, e};
		for (Cat cat : cats) {
			System.out.println(cat);
		}
		System.out.println();
		
		System.out.println("Проверка на корректность реализации Comparable");
		System.out.println(sgn(a.compareTo(b)) == -sgn(b.compareTo(a)));
		System.out.println((a.compareTo(b) > 0 && b.compareTo(c) > 0) && a.compareTo(c) > 0);
		System.out.println(a.compareTo(d) == 0 && (sgn(a.compareTo(c)) == sgn(d.compareTo(c))));
		System.out.println();

		System.out.println("Проверка на согласованность с equals");
		System.out.println(a.equals(d) == true && a.compareTo(d) == 0);
		System.out.println(a.equals(b) == false && a.compareTo(b) != 0);
		System.out.println(a.equals(e) == false && a.compareTo(e) != 0);
		
		Arrays.sort(cats);
		for (Cat cat : cats) {
			System.out.println(cat);
		}

	}

	public static int sgn(int x) {
		if (x > 0) {
			return 1;
		} else if (x < 0) {
			return -1;
		}
		return 0;
	}
}
