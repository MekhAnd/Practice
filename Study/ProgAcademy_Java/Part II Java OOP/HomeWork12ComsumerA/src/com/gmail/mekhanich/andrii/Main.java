package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			list.add(i, rnd.nextInt(100));
		}
		
		System.out.println(list);
		Consumer<List<Integer>> con = a ->{
			for(Integer element: list) {
				if(element%2==0) {
					System.out.print(element);
				}
			}			
		};
		con.accept(list);
	}

}
