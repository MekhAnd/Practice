package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
				
		List<Integer> one = new ArrayList<>(List.of(6, 5, 4, 3, 2,-1));
		List<Integer> two = new ArrayList<>();
		two.add(10);
		two.add(19);
		two.add(9);
		two.add(20);
		two.add(0);
		
		List<String> three = new ArrayList<>();
		three.add("one");
		three.add("zero");
		three.add("four");
		three.add("01");
				
		List<String> four = new ArrayList<>();
		four.add("!!!!");
		four.add("moon");
		four.add("mad");
		four.add("0121");
		
		
		
		 System.out.println(compar(three, four));
		 System.out.println(compar(one, two));
}

public static <T> List<T> compar (List<T> a,List<T> b){
	T mina = a.get(0);
	for (int i = 1; i<a.size() ; i++) {
		if(((Comparable<T>) a.get(i-1)).compareTo(a.get(i))<0) {
			mina = a.get(i-1);
			} else {
			mina = a.get(i);
			}
	}
	T minb = b.get(0);
	for (int i = 1; i<b.size() ; i++) {
		if(((Comparable<T>) b.get(i-1)).compareTo(b.get(i))<0) {
			minb = b.get(i-1);
			} else {
			minb = b.get(i);
			}
	}
	BinaryOperator<T> bin = (y,z) ->{
		if (((Comparable<T>) y).compareTo((T) z)<0) {
			return y;
		} else {
			return z;	
		}
		};
	if(bin.apply(mina, minb)==mina) {
		return a;
	} else {
		return b;
	}
	
}

}
