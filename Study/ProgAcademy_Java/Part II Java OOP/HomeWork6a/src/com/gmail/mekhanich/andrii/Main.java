package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		Thread[] arr = new Thread[103];

		for (int i = 2; i < arr.length; i++) {
			arr[i] = new Thread(new FactorialThread(i));
		}
	
		for (int i = 2; i < arr.length; i++) {
			arr[i].start();
		}
				
		for (int i = 2; i < arr.length; i++) {
			try {
				arr[i].join();
				} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
			

	}

}
