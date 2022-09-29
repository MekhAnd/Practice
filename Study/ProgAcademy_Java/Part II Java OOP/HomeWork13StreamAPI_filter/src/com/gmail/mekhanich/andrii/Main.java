package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String text = "Удалите из строки текста все слова длиннее 5 символов.";
		String [] txt = text.split("\s");
		Stream<String> txtS = Arrays.stream(txt)
				.filter(a->a.length()<=5);
		
		txtS.forEach(a->System.out.println(a));
		
		
	}

}
