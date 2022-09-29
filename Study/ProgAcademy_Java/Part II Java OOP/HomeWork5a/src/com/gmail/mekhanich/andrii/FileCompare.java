package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileFilter;

public class FileCompare implements FileFilter{
	
	private String extension;
	

	public FileCompare(String extension) {
		super();
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "FileCompare [extension=" + extension + "]";
	}

	private boolean check(String ext) {
		if (ext.equals(this.extension)){
				return true;
			}
		return false;
	}
	
	
	@Override
	public boolean accept(File file) {
		int index = file.getName().lastIndexOf(".");
		if (index == -1) {
			return false;
		}
		String ext = file.getName().substring(index + 1);
		return check(ext);
	}
	
	
	
	
	
}
