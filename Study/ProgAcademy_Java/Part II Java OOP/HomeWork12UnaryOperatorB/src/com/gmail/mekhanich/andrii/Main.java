package com.gmail.mekhanich.andrii;

import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {
		String txt = "Hello, 123 Java!";
		
		UnaryOperator<String> unop = (a) -> a.replaceAll("[a-zA-Z()'\" !?,.]", "");
		
		System.out.println(unop.apply(txt));

	}

}
