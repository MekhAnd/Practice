package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;

public class LookingThread implements Runnable{
	
	private File lookingFor;
	private File where;
	private FileOperations thr;
	private int start;
	private int stop;

	
	public LookingThread(File lookingFor, File where, FileOperations thr, int start, int stop) {
		super();
		this.lookingFor = lookingFor;
		this.where = where;
		this.thr = thr;
		this.start=start;
		this.stop=stop;
	}
	
	public LookingThread() {
		super();
	}

	public File getLookingFor() {
		return lookingFor;
	}
	public void setLookingFor(File lookingFor) {
		this.lookingFor = lookingFor;
	}
	public File getWhere() {
		return where;
	}
	public void setWhere(File where) {
		this.where = where;
	}

	@Override
	public String toString() {
		return "LookingThread [lookingFor=" + lookingFor + ", where=" + where + "]";
	}

	@Override
	public void run() {
		Thread a = Thread.currentThread();
		System.out.println("thread " + a.getName() + " was started" );
		try {
				thr.action(this.lookingFor, this.where,this.start, this.stop);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
}
