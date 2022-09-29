package com.gmail.mekhanich.andrii;

public class Pier {

	private boolean flag;
	
	public Pier(boolean flag) {
		super();
		this.flag = flag;
		}

	public Pier() {
		super();
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Pier [flag=" + flag + "]";
	}


	public synchronized void action(int capacity, boolean turn) {
		Thread a = Thread.currentThread();
		while (this.flag != turn && capacity>0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int temp = capacity;
		for (;this.flag == turn&& capacity>0;) {
			try {
				for (int i = temp; i > 0; i -= 1) {
					capacity-=1;
					wait(500);
					System.out.println("The ship "+ a.getName() + " unload " + " this is " + i + " from " + capacity);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.flag = !this.flag;
			notifyAll();

		}

	}

}
