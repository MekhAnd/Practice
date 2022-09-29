package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class ReaderThread implements Runnable {
	private File source;
	private File destination;
	private boolean action;
	private boolean swch;
	private byte [] bundle;
	private int readByte;
	private int counter;
	private PipedInputStream inputStream = new PipedInputStream();
	private PipedOutputStream outputStream = new PipedOutputStream(); 
	
	

	public ReaderThread(File source, File destination, boolean action, boolean swch) {
		super();
		this.source = source;
		this.destination = destination;
		this.action = action;
		this.swch = swch;
		}

	public ReaderThread() {
		super();
	}

	public File getSource() {
		return source;
	}

	public void setSource(File sourse) {
		this.source = source;
	}

	public File getFolder() {
		return destination;
	}

	public void setFolder(File folder) {
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

		
	public int getReadByte() {
		return readByte;
	}

	public void setReadByte(int readByte) {
		this.readByte = readByte;
	}
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "ReaderThread [sourse=" + source + ", folder=" + destination + ", action=" + action + ", swch=" + swch
				+ ", bundle=" + Arrays.toString(bundle) + "]";
	}
	
	public PipedOutputStream getOutputStream() {
		return outputStream;
	}
	
	public synchronized void reader () throws IOException {
		Thread x = Thread.currentThread();
		System.out.println(x.getName() + " I`m on! Reader");
		byte [] reader = new byte [1024*1024];
		this.bundle = new byte [reader.length];
		int readByte = 0;
		int stop = 1048576;
		int counter = 0;
		try (FileInputStream fis = new FileInputStream(this.source)){
		//	while(!swch) {
			for (;(readByte=fis.read(reader))>0;) {
				this.outputStream.write(reader);
//				counter +=1;
//				reader = fis.readNBytes(stop);
//				setBundle(reader);
//				for (int i = 0; i<this.bundle.length; i+=1){
//					bundle[i] = reader[i];
			//		}
			//		this.swch = true;
				System.out.println(swch+ " " + x.getName());
			//	setCounter(counter);
				}
			
				
			}
			} catch (IOException e) {
				throw e;
			}
		
		
		
		return this.bundle;
	}
	
	@Override
	public void run() {
		try {
			reader();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	 

}
