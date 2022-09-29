package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
			String text = "Global ttt stocks and U.S. index futures rose modestly as signs of a solid recovery in the world’s largest economy offset jitters over inflation and a faster tapering of Federal Reserve stimulus.";
			List<String> txt = new ArrayList<>(List.of(text.split("\s")));
			
			int result = txt.stream()
					.map(a->a.length())
					.filter(a-> a>4)
					.reduce(0,(a,b) -> a+b);
			
			System.out.println(result);
	}

}
