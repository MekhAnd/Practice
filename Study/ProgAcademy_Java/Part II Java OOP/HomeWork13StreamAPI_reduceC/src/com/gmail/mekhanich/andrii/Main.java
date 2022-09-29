package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;


public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(6, 2, 4, 6, 8, 10, 12, 1, 2, 0));
		BiPredicate<Integer,Integer> pr = (a,b) -> a>b;
		BinaryOperator<Integer> biF = (a,b) -> pr.test(a, b)? a:b;
		
		int result = list.stream().reduce(0,biF);
		
		System.out.println(result);
	}

}
