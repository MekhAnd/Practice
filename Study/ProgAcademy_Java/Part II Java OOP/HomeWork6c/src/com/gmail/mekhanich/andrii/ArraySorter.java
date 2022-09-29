package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class ArraySorter {

	private int[] arr;
	private int startPoint;
	private int stopPoint;
	private Thread [] a;
	
	public ArraySorter() {
		super();
	}

	public ArraySorter(int[] arr, int startPoint, int stopPoint) {
		super();
		this.arr = arr;
		this.startPoint = startPoint;
		this.stopPoint = stopPoint;
		
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getStopPoint() {
		return stopPoint;
	}

	public void setStopPoint(int stopPoint) {
		this.stopPoint = stopPoint;
	}

	public int[] arraySorter(int startPoint, int stopPoint) {
		Thread a = Thread.currentThread();
		int d = (stopPoint - startPoint) / 2;
		while (d > 0) {
			for (int i = startPoint; i < stopPoint; i += 1) {
				for (int j = i; j >= startPoint && this.arr[j] < this.arr[j - startPoint]; j -= 1) {
					int temp = this.arr[j];
					this.arr[j] = this.arr[j - d];
					this.arr[j - d] = temp;
				}
				System.out.println(Arrays.toString(arr) + " " +a.getName());
			}
			d = d / 2;
		}

		return this.arr;
	}

	
	
	
	public int arraySum(int startPoint, int stopPoint) {
		int sum = 0;
		for (int i = 0; i < this.arr.length; i++) {
			sum += this.arr[i];

		}
		return sum;
	}

}
