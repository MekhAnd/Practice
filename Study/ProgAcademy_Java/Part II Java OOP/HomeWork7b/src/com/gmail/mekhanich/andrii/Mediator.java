package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class Mediator implements Runnable{
	
	private ReaderThread copy;
	private boolean flag;
	private boolean action;
	private byte [] bundle;
	private int readByte;
	private PipedInputStream inputStream = new PipedInputStream();
	private PipedOutputStream secondOutStream = new PipedOutputStream();
	
	public Mediator(ReaderThread copy, boolean flag, boolean action) {
		super();
		this.copy = copy;
		this.flag = flag;
		this.action = action;
		
	}

	public Mediator() {
		super();
	}

	public ReaderThread getCopy() {
		return copy;
	}

	public void setCopy(ReaderThread copy) {
		this.copy = copy;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public byte[] getBundle() {
		return bundle;
	}

	public void setBundle(byte[] bundle) {
		this.bundle = bundle;
	}

		
	public int getReadByte() {
		return readByte;
	}

	public void setReadByte(int readByte) {
		this.readByte = readByte;
	}

	@Override
	public String toString() {
		return "Mediator [copy=" + copy + ", flag=" + flag + ", action=" + action + ", bundle="
				+ Arrays.toString(bundle) + "]";
	}
	
	public boolean chckStatus () {
		if (copy.isSwch()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean chckActivity () {
		if (!copy.isAction()) {
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized byte [] transfer () throws IOException {
		Thread x = Thread.currentThread();
		System.out.println(x.getName() + " I`m on! Mediator");
		this.inputStream = copy.getOutputStream();
		while(chckStatus ()) {
			setReadByte(copy.getReadByte()); 
			//this.bundle = new byte [copy.getBundle().length];
			setBundle(getBundle());
			long summ = 0;
			long portion = copy.reader().length;
			summ +=portion;
			int status = (int)(portion/ copy.getSource().length());
			System.out.println(status +"% was added" + (summ/1048576) + " total copied");
		}
		this.flag = true;
		
		copy.setSwch(false);
		return this.copy.reader();
	}

	@Override
	public void run() {
		try {
			transfer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
 
}
