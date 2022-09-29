package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Main {

	//Создайте реализацию BinaryOperator<String> которая будет возвращать самое 
	//длинное слово из двух строк переданных в качестве параметров.
	
	public static void main(String[] args) {
		String atxt = "1 11 ,,, 2222 5555555555";
		String btxt = "11 222 3333 44444";
		
		String result = longestWord(atxt, btxt);
		System.out.println(result);
	}
	
	
	
	public static String longestWord(String a, String b) {
		Comparator<String> com = (one, two) -> Integer.compare(one.length(), two.length());
		BinaryOperator<String> binOp = BinaryOperator.maxBy(com);
		String max = binOp.apply(breakString(a), breakString(b));
		return max;
	}
	
	public static String breakString(String a) {
		Comparator<String> com = (one, two) -> Integer.compare(one.length(), two.length());
		BinaryOperator<String> binOp = BinaryOperator.maxBy(com);
		String [] text = a.split("\\s");
		System.out.println(Arrays.toString(text));
		String max = "";
		for (int i = 0; i < text.length; i++) {
			max = binOp.apply(text[i], max);
			
		}
		return max;
	}

}
