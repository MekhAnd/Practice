package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Comparator;

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
		
		Comparator<Cat> comp = (one,two) -> one.getName().length() - two.getName().length();
		Arrays.sort(cats, comp);
		
		System.out.println(Arrays.toString(cats));

	}

}
