package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int length = 4;
		int threads = 2;
		int checker = 0;
		int aTrue = 0;
		int aFalse = 0;
		
		while (checker < 1) {
		int firstSum = 0;
		int lastSum =0;
		
		Random rnd = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(10);
		}
		
		
		Thread [] a = new Thread[threads];
		ArraySorter array = new ArraySorter(arr,0, length);
		firstSum = array.arraySum(0, length);
		System.out.println(Arrays.toString(arr));
		
		
		for (int i = 0; i < a.length; i += 1) {
			int startPoint = (length / threads) * i;
			int stopPoint = (length / threads) * (i + 1);
			if (length % threads != 0 && i == (threads - 1)) {
				stopPoint = stopPoint + length % threads;
			}
			a[i] = new Thread(new SorterThreads(arr, startPoint, stopPoint));
			
		}
		
		for (int i = 0; i < a.length; i++) {
			try {
				a[i].join();
				lastSum = array.arraySum(0, length);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(Arrays.toString(arr));
		
		if (firstSum!=lastSum) {
			aFalse+=1;
		} else {
			aTrue +=1;
		}
		
		System.out.println("Attempt = " + checker);
		checker +=1;
	}
		System.out.println("Array parametrs - Length - " + length + "\n Threads - " + threads+ "\nTrue = " + aTrue + " False = " + aFalse + " Attempt = " + checker);
	}
	
}
