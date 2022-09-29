package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> listNum = new ArrayList<>();
		for (int i=0; i<11; i++) {
			int temp =(int)(Math.random()*((100-(-100))+1))-100;	
			listNum.add(i,(Integer)temp);
		}
		listNum.add(-1);
		listNum.add(1);
		
		System.out.println(listNum);
		Comparator<Integer> compOne = (a,b) -> Integer.compare(Math.abs(a), Math.abs(b));
		Comparator<Integer> compTwo = (a,b) -> a.reverse(b);
		Comparator<Integer> compFin = compOne.thenComparing(compTwo);
		
		Integer minElement = Collections.min(listNum,compFin);
		
		System.out.println(minElement);
	}
}
