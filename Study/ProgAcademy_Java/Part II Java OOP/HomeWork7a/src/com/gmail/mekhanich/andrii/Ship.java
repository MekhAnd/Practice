package com.gmail.mekhanich.andrii;

public class Ship {

	private int capacity;

	public Ship(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Ship [capacity=" + capacity + "]";
	}
	
}
