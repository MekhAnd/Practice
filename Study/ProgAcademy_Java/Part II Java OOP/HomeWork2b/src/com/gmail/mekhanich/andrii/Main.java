package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your text:");
		String text = sc.nextLine();
		sc.close();
		
		TextTransformer one = new TextTransformer(text);
		InverseTransformer two = new InverseTransformer(text);
		UpDownTransformer three = new UpDownTransformer(text);
		
		File file = new File ("text_transformer.txt"); 
		
		TextSaver ts = new TextSaver(two, file);
		ts.saveTextToFile(text);
	}

}
