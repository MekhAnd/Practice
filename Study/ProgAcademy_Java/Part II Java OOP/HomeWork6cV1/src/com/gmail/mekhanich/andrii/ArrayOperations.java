package com.gmail.mekhanich.andrii;

public class ArrayOperations implements Runnable {
	private int[] arr;
	private int start;
	private int stop;
	private Thread counter;

	public ArrayOperations(int[] arr, int start, int stop) {
		super();
		this.arr = arr;
		this.start = start;
		this.stop = stop;
		this.counter = new Thread(this);
	}
	
	public Thread getThread() {
		return counter;
	}
	
	public int [] sorter () {
		int element;
		for (int i=start; i<stop; i+=1) {
			int j=i-1;
			element = this.arr[i];
			for(;j>=0&& arr[j]>element;) {
				arr[j+1]=arr[j];
				arr[j]=element;
				j--;
			}
		}
		return arr;
	}

	@Override
	public void run() {
		sorter();
		
	}
	
}
