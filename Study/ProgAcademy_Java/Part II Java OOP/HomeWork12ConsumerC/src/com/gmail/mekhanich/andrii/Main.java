package com.gmail.mekhanich.andrii;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.BiConsumer;

public class Main {

	public static void main(String[] args) {
		String txt = "2021/11/16 The House January 6 investigation hoped to send a fear-inducing message deep into Donald Trump's inner circle by opening the way to the prosecution of Steve Bannon.";
		File b = new File("a.txt");
		BiConsumer<String, File> bicon = Main::addTo; 
		
		bicon.accept(txt, b);

	}
	
	public static void addTo(String a, File b) {
		try(PrintWriter pw = new PrintWriter(new FileWriter(b,true))) {
			pw.println(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
