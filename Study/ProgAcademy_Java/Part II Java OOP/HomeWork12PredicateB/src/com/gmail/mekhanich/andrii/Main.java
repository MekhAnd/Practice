package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>(List.of("awake", "bake", "brake", "cake", "fake", "flake", "Jake", "lake", "make", "quake", "rake", "sake", "shake", "snake", "stake", "take", "wake"));
		char [] array = new char [] {'a','c','J'};
		
		for (int i = 0; i < array.length; i++) {
			String leter = String.valueOf(array[i]);
			Predicate<String> pred = word -> word.startsWith(leter);
			words.removeIf(pred);
		}
		System.out.println(words);
	}
}
