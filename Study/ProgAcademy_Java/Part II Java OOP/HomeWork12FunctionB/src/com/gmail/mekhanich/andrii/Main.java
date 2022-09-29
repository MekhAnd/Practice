package com.gmail.mekhanich.andrii;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		String text = "A federal judge refused Wednesday to block a House committee’s access to Donald Trump’s presidential records while he appeals a previous decision by the judge on those same documents.";
		Function<String, Integer> fun = Main::qChar;
		System.out.println(fun.apply(text));
	}
	
	public static Integer qChar (String text) {
		text = text.replaceAll("[aeiouy.,/s ’]", "");
		return text.length();
	}

}
