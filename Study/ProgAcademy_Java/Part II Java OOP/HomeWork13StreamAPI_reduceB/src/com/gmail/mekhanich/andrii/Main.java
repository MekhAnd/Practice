package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(10, 2, 4, 6, 8, 10, 12, 1, 2, 3));
		int result = list.stream().reduce(1,(a,b)->a*b);
		System.out.println(result);

	}

}
