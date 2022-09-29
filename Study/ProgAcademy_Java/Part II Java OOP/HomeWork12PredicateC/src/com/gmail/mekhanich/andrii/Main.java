package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

		Cat cat1 = new Cat("Umka", 12);
		Cat cat2 = new Cat("Luska", 5);
		Cat cat3 = new Cat("Barsic", 8);
		Cat cat4 = new Cat("Timka", 4);
		Cat cat5 = new Cat("Kuzia", 2);
		List<Cat> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));
		
		System.out.println("Set age");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		Predicate<Cat> prOne = a -> a.getAge()<age;
		System.out.println("Set letter");
		char firstChar = (sc.next()).charAt(0);
		Predicate<Cat> prTwo = a -> a.getName().charAt(0) >firstChar;
		
		cats.removeIf(prOne.and(prTwo));
		
		System.out.println(cats);
	}

}
