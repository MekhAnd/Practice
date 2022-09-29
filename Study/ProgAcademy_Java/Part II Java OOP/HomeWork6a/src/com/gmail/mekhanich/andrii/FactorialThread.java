package com.gmail.mekhanich.andrii;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	private int number;

	public FactorialThread(int number) {
		super();
		this.number = number;
	}

	public FactorialThread() {
		super();
	}

	public int getNumber() {
		return number;
	}

	private BigInteger calculateFactorial (int number) {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			fact = fact.multiply(new BigInteger(""+i));
		}
		return fact;
	}

	public void run () {
		Thread th = Thread.currentThread();
		for (int i = 0; i < this.number; i++) {
			System.out.println(th.getName()+ " " + i + "!= " + calculateFactorial(i));
		}
	}
	
	@Override
	public String toString() {
		return "FactorialThread [number=" + number + "]";
	}
	
}
