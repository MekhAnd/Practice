package com.gmail.mekhanich.andrii;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		HashMap<Character, LetterA> text = new HashMap<>();
		
		text.put((Character)'a', new LetterA());
		
		System.out.println(text.get((Character)'a').toString());
		
	}

}
