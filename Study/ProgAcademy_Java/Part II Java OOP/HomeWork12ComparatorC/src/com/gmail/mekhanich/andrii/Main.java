package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(List.of(62, 2000, 306, 55));
		Comparator<Integer> breakCompare = (a,b) ->Integer.compare(breakNumber(a), breakNumber(b));
		list.sort(breakCompare);
		
		System.out.println(list);
	}

	public static int breakNumber(int a) {
		int temp = a;
		int last = 0;
		int first = 0;
		
		int counter = String.valueOf(Math.abs(a)).length();
		for (int i = counter; i > 0; i--) {
			if(i==counter) {
				last = temp%10;
				}
			if(i==1) {
				first = temp;
				}
			temp = temp/10;
		}
		return first + last;
	}

}
