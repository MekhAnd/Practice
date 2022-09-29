package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод для сохранения двумерного массива целых чисел в файл
		
		File array = new File("array.txt");
		try {
			array.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("Please enter the array length [x] and [y]");
		Scanner sc = new Scanner(System.in);
		
		int iLength = sc.nextInt();
		int jLength = sc.nextInt();
		saveTo(arrayToSave (createArray(iLength, jLength)), array); ;
		
	}
	
	public static String arrayToSave(int [][] arr) {					
		StringBuilder sb = new StringBuilder();
		for (int[] row : arr) {
			for (int col : row) {
				sb.append(String.format("%1.2s  ", ""+col));
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public static int [][] createArray(int a, int b){				
		int [][] arr = new int [a][b];
		
		for (int i = 0; i <= a-1; i++) {
			for (int j = 0; j < b; j++) {
				arr[i][j] = (int) (Math.random() * (10 - 1) + 1);
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		return arr;
	}
	
	public static void saveTo (String text, File array) {			
	
		try (PrintWriter pw = new PrintWriter(array)){
			pw.println(text);
		}catch (IOException e) {
			System.out.println(e);
		}
	} 
	

}
