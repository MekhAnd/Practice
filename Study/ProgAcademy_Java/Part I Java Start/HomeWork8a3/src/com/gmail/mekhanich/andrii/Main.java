package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод который выведет на экран список каталогов, которые "лежат" в каталоге, который будет его параметорм
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the path:");
		
		String path = sc.next();
		File folder = new File(path);
		list(folder);	

	}
	
	public static void list (File folder) {
		File [] files = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
			}
		}
	}

}
