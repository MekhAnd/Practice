package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class SumThreads implements Runnable{

	private int [] array;
	private int startPoint;
	private int stopPoint; 
	private Thread a = new Thread (this.a);
	private long summ;
	
	
	
	public SumThreads(int[] array, int startPoint, int stopPoint) {
		super();
		this.array = array;
		this.startPoint = startPoint;
		this.stopPoint = stopPoint;
		//this.a.start();
		}

	public SumThreads() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
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

	public Thread getA() {
		return a;
	}

	public void setA(Thread a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "SumThreads [array=" + Arrays.toString(array) + ", startPoint=" + startPoint + ", stopPoint=" + stopPoint
				+ ", a=" + a + "]";
	}

	public long summ () {
		//Thread temp = Thread.currentThread();
		ArrayCalculation array = new ArrayCalculation(this.array, startPoint, stopPoint);
		long sum = 0;
		System.out.println(this.getA().getName());
		sum += array.arrayGetSum(this.array);
		return sum;
	}
	
		
	@Override
	public void run() {
		summ();	
		
	}
	
	
	
	
	

	
	
	
	
	
}
