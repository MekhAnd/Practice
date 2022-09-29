package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		File folder = new File("G:\\Java_OOP_WorkSpace\\");
		
		List<String> list = Arrays.stream(folder.listFiles())
				.map(a->a.getName())
				.filter(a-> a.contains(".txt"))
				.collect(Collectors.toList());
		System.out.println(list);
		
		
		
	}

}
