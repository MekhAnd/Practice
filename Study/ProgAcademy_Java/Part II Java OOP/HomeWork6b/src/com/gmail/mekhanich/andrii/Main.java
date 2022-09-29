package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int length = 200_000_000;
		int threads = 8;
		int [] array = new int [length];
		
		long fillStart = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*10);
		}
		long fillStop = System.currentTimeMillis();
		long arrayF = fillStop - fillStart;
		
		
		long usualStart = System.currentTimeMillis();
		ArrayCalculation a = new ArrayCalculation(array, 0, length);
		System.out.println(a.arraySum(array));
		long usualStop = System.currentTimeMillis();
		long usual = usualStop - usualStart;
		
		
		
		long threadsStart = System.currentTimeMillis();
		SumThreads [] threadArray = new SumThreads [threads];
		for (int i = 0; i < threadArray.length; i++) {
			int start = (length / threads)*i;
			int stop = (length / threads) * (i + 1);
			if (length % threads != 0 && i == (threads - 1)) {
				stop = stop + length % threads;
			}
			threadArray[i] = new SumThreads(array, start, stop);
			
		}
	
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].getA().start();
			}
		
		long sum = 0;
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].getA().join();
				System.out.println(threadArray[i].getA().getName() + " = " +threadArray[i].summ());
				sum += threadArray[i].summ();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		long threadsStop = System.currentTimeMillis();
		long threadT = threadsStop - threadsStart;
		
		
		System.out.println("Array filling = " + arrayF);
		System.out.println("Usual calculating  = " + usual);
		
		System.out.println("Calculating with "+ threads +" threads = " + threadT);
		System.out.println("Arrays parametrs - " + array.length);
	}

}
