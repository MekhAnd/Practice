package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Integer> listNum = new ArrayList<>();
		Random rnd = new Random();
		for (int i=0; i<3; i++) {
			listNum.add(i,rnd.nextInt(100));
		}
				System.out.println(listNum);
		List<Integer> simpleList = new ArrayList<>();
		Function <List <Integer>, List<Integer>> first = a ->{
			int countNumber = 0;
			for(int i = 0; i<listNum.size();i++) {
				int count = 0;
				for (int j = 1; j<100; j++) {
					if(listNum.get(i)%j==0) {
						count++;
					}
				}
				if(count<3) {
					simpleList.add(countNumber, listNum.get(i));
				}
			}
			return simpleList;
		};  
		
		first.apply(listNum);
		System.out.println(simpleList);
		
		Predicate<List <Integer>> second = a -> a.size()>0;
		if(second.test(simpleList)) {
			Comparator<Integer> element = (a,b) -> Integer.compare(a,b);
			Integer mElement = Collections.max(simpleList,element);
			 System.out.println(mElement +" - is the biggest simple number.");
		} else {
			Comparator<Integer> element = (a,b) -> Integer.compare(a,b);
			Integer mElement = Collections.min(listNum,element);
			 System.out.println("There is no any simple nuber, and the number " + mElement + " - is the minimal nuber in this list.");
		}
	}
}
