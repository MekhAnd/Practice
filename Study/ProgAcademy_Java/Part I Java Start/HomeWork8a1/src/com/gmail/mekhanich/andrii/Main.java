package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// Текстовой (консольный) редактор 
		File txt = new File ("simple.txt");
		try {
			txt.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("Please input your text. Type *X* to stop input the text:");
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String text = "";
		
		String a = "";
		for (;!a.equalsIgnoreCase("*X*");) {
				a = "";
				a = sc.nextLine();
				sb.append (a);
				sb.append (System.lineSeparator());
				text = sb.toString();
			}
			
			
			saveToFile(text, txt);
			System.out.println ("Your text was saved to file!");
		
	}
	
	public static void saveToFile (String text, File txt) {
		try (PrintWriter pw = new PrintWriter(txt)){
			pw.println(text);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
