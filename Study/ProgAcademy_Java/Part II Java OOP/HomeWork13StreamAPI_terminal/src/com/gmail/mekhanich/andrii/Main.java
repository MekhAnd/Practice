package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\HomeWork13StreamAPI_terminal\\folders.txt");
		List<String> lines = new ArrayList<>();

		Stream<String> flow;
		try {
			flow = Files.lines(path).filter(folder-> (check(folder)>=3));
			Optional<String> term = flow.findAny();
			System.out.println(term.get());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static int check (String a) {
		int result = 0;
		File url = new File (a);
		File [] b = url.listFiles();
		for (int i = 0; i < b.length; i++) {
			if(b[i].isFile()&&b[i].getName().contains(".txt")) {
				result+=1;
			}
			}
		return result;
		}
	
}
