package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;

public class CopyThreads implements Runnable {

	private File in;
	private File out;
	private int start;
	private int stop;

	public CopyThreads(File in, File out, int start, int stop) {
		super();
		this.in = in;
		this.out = out;
		this.start = start;
		this.stop = stop;
	}

	public CopyThreads() {
		super();
	}
	
	
	
	@Override
	public void run() {
		try {
			FileOperations.fileCopy(in, out, start, stop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
