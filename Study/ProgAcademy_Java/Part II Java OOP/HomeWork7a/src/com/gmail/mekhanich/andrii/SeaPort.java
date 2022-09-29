package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class SeaPort implements Runnable{
	
	private int numberOfDocs;
	private Ship [] fleet;
	private Thread liftCrane;
	
	public SeaPort(int numberOfDocs, Ship[] fleet) {
		super();
		this.numberOfDocs = numberOfDocs;
		this.fleet = fleet;
		this.liftCrane = new Thread(this);
		liftCrane.start();
		
	}	
	
	public SeaPort() {
		super();
	}

	public int getNumberOfDocs() {
		return numberOfDocs;
	}

	public void setNumberOfDocs(int numberOfDocs) {
		this.numberOfDocs = numberOfDocs;
	}

	public Ship[] getFleet() {
		return fleet;
	}

	public void setFleet(Ship[] fleet) {
		this.fleet = fleet;
	}

	@Override
	public String toString() {
		return "SeaPort [numberOfDocs=" + numberOfDocs + ", fleet=" + Arrays.toString(fleet) + "]";
	}
	
	public synchronized void unload () {
		Thread tmp = Thread.currentThread();
			try {
				for (int i = 0; i< this.fleet.length; i+=1) {
					while (fleet[i].getCapacity()!=0) {
						int circle = fleet[i].getCapacity();
						fleet[i].setCapacity(circle - 1);
						System.out.println("This is " + circle + " box from ship " + i + " " + fleet[i].toString()+ " " + tmp.getName());
						wait(1000);
					}
				} notifyAll();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void run() {
		unload();
	}

}
