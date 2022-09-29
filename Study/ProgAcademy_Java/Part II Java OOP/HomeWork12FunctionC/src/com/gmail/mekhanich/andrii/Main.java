package com.gmail.mekhanich.andrii;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		String text = "Java is the best lenguage";
		
		Function<String, Integer []> one = textIn ->{
			char[] array = text.toCharArray();
			Integer [] ar = new Integer[array.length];
			for (int i = 0; i < array.length; i++) {
				ar[i] = (int)array[i];
				//System.out.println(ar[i] + " - "+array[i]);
			}
			return ar;
		};
		Function<Integer [], Integer> two = a->{
			int sum = 0;
			for (int i = 0; i < a.length; i++) {
				sum +=a[i];
			}
			return sum;
		};
		Function<String, Integer> fin = one.andThen(two);
		System.out.println(fin.apply(text));
		
	}

}
