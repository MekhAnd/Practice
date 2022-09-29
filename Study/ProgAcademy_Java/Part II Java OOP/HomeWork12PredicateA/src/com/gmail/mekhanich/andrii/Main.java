package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>(List.of("awake", "bake", "brake", "cake", "fake", "flake", "Jake", "lake", "make", "quake", "rake", "sake", "shake", "snake", "stake", "take", "wake"));
		Predicate<String> pred = word -> word.startsWith("J") ;
		words.removeIf(pred);
		System.out.println(words);

	}
}
