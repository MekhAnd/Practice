package com.gmail.mekhanich.andrii;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
	
		int docs = 2;
		Ship one = new Ship (10);
		Ship two = new Ship (10);
		Ship thr = new Ship (10);
		
		
		Ship [] fleet = new Ship[]{one,two,thr};
		
		Executor ex = Executors.newFixedThreadPool(docs);
		ex.execute(new SeaPort(docs, fleet));
		((ExecutorService) ex).shutdown();

	}

}
