package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
	
//	Создайте реализацию BinaryOperator<List<Integer>> которая вернет список в котором 
//	будут только те элементы которые одновременно присутствуют в первом и во втором 
//	списке целых чисел использованных в качестве параметров.
	
	public static void main(String[] args) {
		
		List<Integer> listOne = new ArrayList<>(List.of(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
		List<Integer> listTwo = new ArrayList<>(List.of(20, 22, 24, 26, 88, 10, 12, 14, 16, 18));
		
		List<Integer> res = new ArrayList<>();
		BinaryOperator<List<Integer>> biOp = (a,b) -> {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i<a.size(); i++) {
				for (int j = 0; j<b.size(); j++) {
					if(a.get(i)==b.get(j)) {
						tmp.add(a.get(i));
					}
				} 
			}
			return tmp;
		};
		res = biOp.apply(listOne, listTwo);
		
		System.out.println(res);
		
		}
	

}
