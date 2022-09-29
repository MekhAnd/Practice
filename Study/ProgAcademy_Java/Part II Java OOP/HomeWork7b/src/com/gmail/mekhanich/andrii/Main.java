package com.gmail.mekhanich.andrii;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File source = new File("J:\\films\\VID_20200618_121107.mp4");
		File destination = new File("J:\\films\\");
		
		ReaderThread one = new ReaderThread(source, destination, false, false);
		Mediator two = new Mediator(one, false, false);
		WriterThread thr = new WriterThread(two, one, source, destination, false, false);
		
		Thread a = new Thread (new ReaderThread(source, destination, false, false));
		Thread b = new Thread (new Mediator(one, false, false));
		Thread c = new Thread (new WriterThread(two, one, source, destination, false, false));
		
		a.start();
		b.start();	
		c.start();
		
//		try {
//			a.join();
//			b.join();
//			c.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
