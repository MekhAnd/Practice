package com.gmail.mekhanich.andrii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		TheBigBangHero drSheldon = new TheBigBangHero("Sheldon Cooper");
		TheBigBangHero drLeonard = new TheBigBangHero("Leonard Hofstadter");
		TheBigBangHero drRajesh  = new TheBigBangHero("Rajesh Koothrappali");
		TheBigBangHero mrHoward   = new TheBigBangHero("Howard Wolowitz");
		TheBigBangHero msPenny  = new TheBigBangHero("Penny Teller");
		
		System.out.println("Set, how many glasses they should drink");
		Scanner sc = new Scanner(System.in);
		int glass = sc.nextInt();
		
		Deque<TheBigBangHero> chain = new ArrayDeque();
		chain.add(msPenny);
		chain.add(mrHoward);
		chain.add(drSheldon);
		chain.add(drLeonard);
		chain.add(drRajesh);
		
		for (int i = 0; i <= glass; i++) {
			chain.addLast(chain.pollFirst()); 
			chain.addLast(chain.getLast());
			System.out.println(chain);
		}
		

	}

}
