package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class ArrayCalculation {
 
	private int [] array;
	private long summ = 0;
	private int start;
	private int stop;
	
	public ArrayCalculation(int[] array, int start, int stop) {
		super();
		this.array = array;
		this.start = start;
		this.stop = stop;
	}
	public ArrayCalculation() {
		super();
	}
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void setSumm(long summ) {
		this.summ = summ;
	}
	
	public long getSumm() {
		return summ;
	}
	@Override
	public String toString() {
		return "ArrayCalculation [array=" + Arrays.toString(array) + ", summ=" + summ + "]";
	}
	
	public long arrayGetSum (int [] array) {
		for (int i = this.start; i < this.stop; i+=1) {
			this.summ += array[i];
		}
		return summ;
	}
	
	public long arraySum (int [] array) {
		for (int i = this.start; i < this.stop; i+=1) {
			this.summ += array[i];
		}
		return summ;
	}
	
	
	
	
}
