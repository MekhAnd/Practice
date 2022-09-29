package com.gmail.mekhanich.andrii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		gamesWithList();
	}
	
	public static void gamesWithList() {
		List<Integer> adList = new ArrayList();
		
		for (int i = 0; i <= 10; i++) {
			adList.add(i);
		}
		System.out.println(adList);

		System.out.println(adList.remove(0) + " was deleted!");
		System.out.println(adList.remove(0) + " was deleted!");
		
		System.out.println();
		System.out.println(adList + " - After deleting first and second elements");
		
		adList.remove(adList.size()-1);
		System.out.println();
		System.out.println(adList + " - After deleting last element");
		
	}

}
