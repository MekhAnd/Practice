package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WriterThread implements Runnable{
	
	private Mediator a;
	private ReaderThread b;
	private File source;
	private File destination;
	private boolean action;
	private boolean swch;
	private byte [] bundle;
	private int readByte;
	
	
	public WriterThread(Mediator a, ReaderThread b, File source, File destination, boolean action, boolean swch) {
		super();
		this.a = a;
		this.b = b;
		this.source = source;
		this.destination = destination;
		this.action = action;
		this.swch = swch;
		
	}


	public WriterThread() {
		super();
	}


	public Mediator getA() {
		return a;
	}


	public void setA(Mediator a) {
		this.a = a;
	}


	public File getSource() {
		return source;
	}


	public void setSource(File source) {
		this.source = source;
	}


	public File getDestination() {
		return destination;
	}


	public void setDestination(File destination) {
		this.destination = destination;
	}


	public boolean isAction() {
		return action;
	}


	public void setAction(boolean action) {
		this.action = action;
	}


	public boolean isSwch() {
		return swch;
	}


	public void setSwch(boolean swch) {
		this.swch = swch;
	}


	public byte[] getBundle() {
		return bundle;
	}


	public void setBundle(byte[] bundle) {
		this.bundle = bundle;
	}


	@Override
	public String toString() {
		return "WriterThread [a=" + a + ", source=" + source + ", destination=" + destination + ", action=" + action
				+ ", swch=" + swch + ", bundle=" + Arrays.toString(bundle) + "]";
	}
	
	public boolean chckActivity () {
		if (a.isAction()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public synchronized void run() {
		Thread x = Thread.currentThread();
		System.out.println(x.getName() + " I`m on! Writer");
		while(chckActivity()) {
		this.readByte = b.getReadByte();
		File out = new File (destination, "greetings.mp4");
		try (FileOutputStream fos = new FileOutputStream(out)){
			for (;(a.transfer()!=null);) {
				fos.write(b.getBundle(), 0, readByte);
				}
			} catch (FileNotFoundException z) {
				z.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		a.setFlag(false);
		}
		
	}
	
	
	
	

}
