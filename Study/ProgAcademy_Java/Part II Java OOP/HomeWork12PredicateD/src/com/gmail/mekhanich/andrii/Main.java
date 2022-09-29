package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiPredicate;

public class Main {

	public static void main(String[] args) {
		Map<Integer, String> words = new HashMap<>();
		String[] array = new String[] { "awake", "bake", "brake", "cake", "fake", "flake", "Jake", "lake", "make",
				"quake", "rake", "sake", "shake", "snake", "stake", "take", "wake" };
		for (int i = 0; i < array.length; i++) {
			words.put(i, array[i]);
		}
		int size = words.size();
		
		for (int i = 0; i <size; i++) {
			BiPredicate<Integer, String> bipr = (a, b) -> a != b.length();
			if (bipr.test(i, words.get(i))) {
				words.remove(i, words.get(i));
			} 
		}
		System.out.println(words);
	}
}
