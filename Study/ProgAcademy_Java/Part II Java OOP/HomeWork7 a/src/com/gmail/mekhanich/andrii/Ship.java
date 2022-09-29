package com.gmail.mekhanich.andrii;

public class Ship implements Runnable {

	private int capacity;
	private Pier one;
	private boolean flag;
	
	public Ship(int capacity, Pier one, boolean flag) {
		super();
		this.capacity = capacity;
		this.one = one;
		this.flag = flag;
	}

	public Ship() {
		super();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Pier getOne() {
		return one;
	}

	public void setOne(Pier one) {
		this.one = one;
	}
		public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Ship [capacity=" + capacity + ", one=" + one + " ]";
	}

	@Override
	public void run() {
		one.action(this.capacity, this.flag);
	}
}
