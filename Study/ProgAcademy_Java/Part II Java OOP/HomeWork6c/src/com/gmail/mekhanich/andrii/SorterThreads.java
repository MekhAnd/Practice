package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class SorterThreads implements Runnable {
	private int [] ar;
	private int minBound;
	private int maxBound;
	private Thread a;
	private int index;
	
	
	public SorterThreads(int[] ar, int minBound, int maxBound) {
		super();
		this.ar = ar;
		this.minBound = minBound;
		this.maxBound = maxBound;
		a = new Thread(this);
		a.start();
	}


	public SorterThreads() {
		super();
	}
	
	public ArraySorter arrayOperations () {
		ArraySorter array = new ArraySorter(this.ar, this.minBound, this.maxBound);
		array.arraySorter(maxBound, maxBound);
		System.out.println(Arrays.toString(array.arraySorter(maxBound, maxBound)));
		return array;
	}

	@Override
	public void run() {
		arrayOperations();
		
	}

	
}
