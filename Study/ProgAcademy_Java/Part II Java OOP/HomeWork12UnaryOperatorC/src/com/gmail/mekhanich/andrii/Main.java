package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {
		
		List<String> baseList = new ArrayList<>(List.of("Java", "Hello", "missed", "immediate", "Scot", "Forwards", "Defenders", "people", "Champions", "Hampden"));
		List<String> finalList = new ArrayList<>();
		
		UnaryOperator<List<String>> unop = a-> {
			List <String> tmp = new ArrayList<>();
			for(int i=0; i<a.size(); i++) {
				if((a.get(i).length())>5) {
					tmp.add(a.get(i));
				}
			}
			return tmp;
		};
		
		finalList = unop.apply(baseList);
		
		System.out.println(finalList);

	}

}
