package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Arrays;

public class FileMonitor implements Runnable{
	private File folder;
	private int qFiles;
	private int realLength;

	public FileMonitor(File folder) {
		super();
		this.folder = folder;
		this.realLength = (folder.listFiles()).length;
		
	}

	public FileMonitor() {
		super();
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public boolean monitor () {
		if (this.folder!=null) {
			File [] folderArray = this.folder.listFiles();
			int qFiles = folderArray.length;
			if (qFiles == realLength) {
				System.out.println(this.realLength + " files was in this folder " + qFiles + " files is in this folder. Everything is Ok!!!");
				return true;
			} else {
				System.out.println("RED ALERT!!! " + ( qFiles - this.realLength) + " files is in this folder. Something went wrong(((!!!");
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	
	
	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for (;!th.isInterrupted();) {
			if (this.monitor()) {
				System.out.println("Still watching!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("I WAS KILLED BY MAIN POCESS :(");
					break;
				}
			} else {
				break;
			}
		}
		System.out.println("Monitoring have done!");
		
	} 
	
	
}
