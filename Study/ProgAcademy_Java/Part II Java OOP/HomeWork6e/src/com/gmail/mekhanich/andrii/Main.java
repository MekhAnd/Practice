package com.gmail.mekhanich.andrii;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File folder = new File("J:\\EnglishDom\\Intermediate\\");
		
		Thread th = new Thread (new FileMonitor(folder));
		th.start();
		try {
			Thread.sleep(60000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		th.interrupt();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
