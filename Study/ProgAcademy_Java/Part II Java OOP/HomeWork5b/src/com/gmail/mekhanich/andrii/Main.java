package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("G:\\Java_OOP_WorkSpace\\test.txt");
		File testOne = new File("G:\\Java_OOP_WorkSpace\\test1.txt");
		FileCompareByWords first = new FileCompareByWords(test, testOne);
		
		try {
		first.writerCSV(first.srchResult(first.ar(test), first.ar(testOne)));
		} catch (IsNotFileExeption e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
