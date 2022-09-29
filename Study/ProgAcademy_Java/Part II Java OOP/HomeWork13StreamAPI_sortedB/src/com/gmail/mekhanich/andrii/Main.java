package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		List<Integer> num = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			num.add(i, rnd.nextInt(99));
		}
		System.out.println(num);
		
		Stream<Integer> newNum = num.stream()
				.filter(a-> a>10)
				.sorted((a,b)-> ((a%10)-(b%10)));
				
				newNum.forEach(a->System.out.println(a));

				
					
	}
}
