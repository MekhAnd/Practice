package com.gmail.mekhanich.andrii;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Pier one = new Pier(false);
			
						
		Executor ex = Executors.newFixedThreadPool(3);
		ex.execute(new Ship(10,one, false));
		ex.execute(new Ship(10,one, false));
		ex.execute(new Ship(10,one, true));
		
//		
//		Ship first = new Ship(10, one, true, true);
//		Ship second = new Ship(10, one, false, true);
//		Ship third = new Ship(10, one, false, true);
//		
		
//		new Thread(first).start();
//		new Thread(second).start();
//		new Thread(third).start();
//		

//		new Thread(first).join();
//		new Thread(second).join();
//		new Thread(third).join();
//		
	}
}
