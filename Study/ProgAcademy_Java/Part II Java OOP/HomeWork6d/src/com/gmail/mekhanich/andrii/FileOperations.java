package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {

	private File a;
	private File b;
	private File [] list;

	public FileOperations() {
		super();
	}

	public FileOperations(File a, File b, File [] list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}

	public File getA() {
		return a;
	}

	public void setA(File a) {
		this.a = a;
	}

	public File getB() {
		return b;
	}

	public void setB(File b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "FileOperations [a=" + a + ", b=" + b + "]";
	}
	
	public File [] setList (File a) {
		if(a.isDirectory()) {
			this.list = a.listFiles();
		} else {
			System.out.println("Incorrect input - this is not folder!");
		}
		return list;
	}
	
	public static void fileCopy(File in, File out, int start, int stop) throws IOException {
		Thread ath=Thread.currentThread();
		byte [] buf = new byte [1024*1024];
		int readByte = 0;
		File [] list = in.listFiles();
			for (int i = start; i< stop; i+=1) {
				File source = new File (in, list[i].getName());
				File destination = new File (out, list[i].getName());
				try (FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(destination)){
					for (;(readByte=fis.read(buf))>0;) {
						fos.write(buf, 0, readByte);
						}
					} catch (IOException e) {
						throw e;
					}
			}
			System.out.println(ath);
	}

}
