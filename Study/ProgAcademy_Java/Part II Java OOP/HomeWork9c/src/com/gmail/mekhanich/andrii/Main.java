package com.gmail.mekhanich.andrii;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File text = new File ("G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\HomeWork9c\\By David Robson.txt");
		FileToCharOperations one = new FileToCharOperations(text);
		
		one.counter();

	}

}
