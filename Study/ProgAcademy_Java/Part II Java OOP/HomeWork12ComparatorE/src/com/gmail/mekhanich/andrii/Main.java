package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Function;


public class Main {

	public static void main(String[] args) {
		File a = new File ("G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\HomeWork12ComparatorE\\a.txt");
		File b = new File ("G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\HomeWork12ComparatorE\\b.txt");
				
		Function<File, String> func1 = Main::reader;
		Function<String,Integer> func2= Main::diff;
		Function<File, Integer> func3 = func1.andThen(func2);
		System.out.println("Total length of files is: a.txt = "+diff(reader(a)) +" and b.txt = " + diff(reader(b)));
		
		Comparator<File> compare =(one,two) -> (func3.apply(one)).compareTo(func3.apply(two));
			
		if((compare.compare(a,b)>0)) {
			System.out.println("A file bigger then B file");
		} else if((compare.compare(a,b)==0)) {
			System.out.println("A file is eqaual B file");
		} else {
			System.out.println("A file smaller then B file");
		}
		
			
	}
	
	public static String reader(File a) {
		String txt = "";
		try(BufferedReader br = new BufferedReader(new FileReader(a))){
			StringBuffer sb = new StringBuffer();
			String text = br.readLine();
			while(text !=null) {
				sb.append(text);
				text = br.readLine();
			}
			txt = sb.toString();
			txt = txt.toLowerCase();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return txt;
	}
	
	public static Integer diff(String a) {
		Integer length = (a.replaceAll("[a-zA-Z0-9()'\"]", "")).length();
		
		return length;
	}

}
