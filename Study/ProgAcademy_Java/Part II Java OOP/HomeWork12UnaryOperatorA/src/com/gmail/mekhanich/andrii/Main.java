package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		UnaryOperator<Integer> unop = (a) -> a%2==0? a:0;
		int i=0;
		for (Integer element : list) {
			list.set(i,unop.apply(element));
			i++;
		}
		
		System.out.println(list);
	}
}
