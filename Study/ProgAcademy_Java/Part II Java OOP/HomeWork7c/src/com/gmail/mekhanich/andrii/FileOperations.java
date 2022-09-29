package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;

public class FileOperations {

	private File lookingFor;
	private File where;
	private int start;
	private int stop;

	public FileOperations(File lookingFor, File where, int start, int stop) {
		super();
		this.lookingFor = lookingFor;
		this.where = where;
		this.start = start;
		this.stop = stop;
	}

	public FileOperations() {
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

	public String getFileName() {
		return this.lookingFor.getName();
	}

	@Override
	public String toString() {
		return "FileOperations [lookingFor=" + lookingFor + ", where=" + where + "]";
	}

	public File[] checker(File folder) {
		Thread tmp = Thread.currentThread();
		File[] directory = folder.listFiles();
		return directory;
	}

	public synchronized void action(File lookingFor, File where, int start, int stop) {
		Thread a = Thread.currentThread();
		File[] tmp = checker(where);
		if (tmp.length != 0) {
			for (int i = start; i < stop; i += 1) {
				if (tmp[i].isFile()) {
					if (tmp[i].getName().equals(this.lookingFor.getName())) {
						System.out.println(a.getName() + " " + tmp[i].getPath());
					}
				} else {
					action(this.lookingFor, tmp[i], 0, checker(tmp[i]).length);
				}
			}
		}
	}

}
