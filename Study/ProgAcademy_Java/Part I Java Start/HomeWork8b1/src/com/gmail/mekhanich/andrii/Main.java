package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод для считывания двумерного массива из файла
		// G:\Java_WorkSpace2\Lesson8b\matrix.txt

		Scanner sc = new Scanner(System.in);
		System.out.println("Please, input the pass to your file:");
		String path = sc.nextLine();
		File matrix = new File(path);
		loadTextFile(matrix);
		//System.out.println(text);

	}

	public static void loadTextFile(File file) {
		StringBuilder sbd = new StringBuilder();
		int row = 0;
		int col = 0;
		String matrix = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
			for (; (matrix = bfr.readLine()) != null;row++) {
				sbd.append(matrix);
				sbd.append(System.lineSeparator());
				if(row>=1) {
				col = (matrix.length() - 2)/row;
				System.out.println(col);
				}
				
			}
			
						
		} catch (IOException e) {
			System.out.println(e);

		}
		
		matrix = sbd.toString();
		System.out.println(matrix);
		//col = (matrix.length() - 2)/6;
		System.out.println(matrix.length() + " " + col);
		
		String [] nextArray = matrix.split("\\W");
		int zz = nextArray.length;
		int [][] b = new int [row-1][col-1];
		int count = 0;
		for(int i = 0; i < row-1 ; i++) {
			for (int j = 0; j <= col-1; j++, count++)
			try {
				b[i][j] = Integer.parseInt(nextArray[count]);
				
			}catch (NumberFormatException e) {
				//System.out.println(e);
			}
		}
		
		System.out.println(zz + " " + row);
		System.out.println(Arrays.toString(nextArray));
		System.out.println(Arrays.toString(b));
		
		
		/*int col = array.length() / row;
		char[] a = new char[array.length() - 1];
		a = array.toCharArray();
		int [][] b = new int [row-1][col];
		int counter = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < col; ) {
				if (a[counter]<=47) {
					b[i][j] = a[counter]-48;
					j++;
					}
				counter++;
			}
		}
		
		System.out.println(array.length() + " " + col + " " + row);
		for (int i = 0; i<b.length-1; i++) {
			System.out.println(Arrays.toString(b[i]));
		}*/
		
		
	}

}
