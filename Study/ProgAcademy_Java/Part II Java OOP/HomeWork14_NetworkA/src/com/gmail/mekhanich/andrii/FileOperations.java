package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FileOperations {
	
	private File a;

	public FileOperations(File a) {
		super();
		this.a = a;
	}

	public File getA() {
		return a;
	}

	public void setA(File a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "FileOperations [a=" + a + "]";
	}
	
	public Set <String> setReader () {
		Set<String> setURLs = new HashSet<>();
		File source = this.a ;
		StringBuffer sb = new StringBuffer();
		String res = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(source))) {
			String text = "";
			for(;(text = bfr.readLine())!=null;) {
				sb.append(text).append(System.lineSeparator());
			}
			res = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		Set<String> b = Arrays.stream(res.split(System.lineSeparator()))
				.collect(Collectors.toSet());
		return b;
		
	}
	
	public void listToFile(Set<String> a) {
		int count = 0;
		try (PrintWriter pw = new PrintWriter(new FileWriter("checked links.txt"))) {
			for (String link : a) {
				URL tmp = new URL(link);
				HttpURLConnection htmp = (HttpURLConnection) tmp.openConnection();
				int chckCode = htmp.getResponseCode();
				if(chckCode>199&&chckCode<300) {
					pw.println(link);
					count++;
				} else {
					System.out.println("This link has some trouble:\n " + link+ "\n" + chckCode + "-was returned");
				}
				pw.flush();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(count + " links was added!");
	}

}
