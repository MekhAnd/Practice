package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOperations {
	
	private File [] list;

	public FileOperations(File[] list) {
		super();
		this.list = list;
	}

	public File[] getList() {
		return list;
	}

	public void setList(File file) {
		if (file.isDirectory()) {
			this.list = file.listFiles(); 
		} else {
			System.out.println("Incorrect input (try to insert path to the folder)");
		}
	}

	@Override
	public String toString() {
		return "FileOperations [list=" + Arrays.toString(list) + "]";
	}
	
	public static void fileCopy(File in, File out, FileCompare arg) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		File [] list = in.listFiles();
			for (File file : list) {
				if(arg.accept(file)) {
					File source = new File (in, file.getName());
					File destination = new File (out, file.getName());
					try (FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(destination)){
						for (;(readByte=fis.read(buffer))>0;) {
							fos.write(buffer, 0, readByte);
						}
					} catch (IOException e) {
						throw e;
					}
				}
			}
	}
	
	
}
