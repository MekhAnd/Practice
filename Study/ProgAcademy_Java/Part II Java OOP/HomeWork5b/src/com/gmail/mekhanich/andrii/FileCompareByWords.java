package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileCompareByWords {
	
	private File a;
	private File b;
	
	public FileCompareByWords(File a, File b) {
		super();
		this.a = a;
		this.b = b;
	}
	

	public FileCompareByWords() {
		super();
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
	
	//check method to understand is this file or link
	public boolean chkr (File file) throws IsNotFileExeption {					
		boolean status = false;
		if (file.isFile()) {
			status = true;
		} else {
			System.out.println("Your link does not point to a file! + [" + file.toString() + "] Check this link!");
			throw new IsNotFileExeption();
		}
		return status;
	}
	
	//filling array from file
	public String [] ar (File file) throws IsNotFileExeption, IOException {			
		String text ="";
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			if(chkr(file)) {	
				for (;(text = br.readLine())!=null;) {
					result += text;
						result += " ";
					}
				}
			} catch (IOException e) {
					e.printStackTrace();
			}	
		String [] ar = result.split(" ");
		return ar;				
	}
	
	//search same words
	public String srchResult (String [] a, String [] b) {
		String result = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i].equals(b[j])) {
					result += a[i]+ ";";
					break;
				}
			}
		}
				
		return result;
	}
	
	//write result to the file
	public void writerCSV (String a) throws IOException {
		File result = new File(".");
		try (PrintWriter pw = new PrintWriter("result.csv")) {
			pw.print(a);
			System.out.println("Have done!");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	

}
