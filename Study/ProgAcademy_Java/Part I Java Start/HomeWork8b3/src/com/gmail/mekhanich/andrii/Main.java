package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		// Метод который создает ASCI арт 40*40 
		//
		
		
		
	       
		File ansiArt = new File("ansi.txt");
		ansi(ansiArt);
		
		}
	
	public static void ansi (File file) {
		try (PrintWriter pw = new PrintWriter(file)){
			for (int i = 0; i<=28; i++) {
				for (int j = 0; j < 39; j++) {
					if ((i ==0 || j == 0 || j == 39 || i == 39) || (i == 5 && (j==7||j==8))) {
						pw.print("-");
					} else if (j==9 ||j==19||j==29||j==39)  {
						pw.print(" ");
					} else if (j == 7||j == 8 || j == 10||j == 11 || j == 17||j == 18 || j == 20||j == 21 || j == 27||j == 28 || j == 30||j == 31 || j == 37||j == 38) {
						pw.print("*");
					} else if (((i > 0 && i < 5) && ((j>=12 && j<=16)||(j>=32 && j<=36)))) {
						pw.print("*");
					} else if ((i > 13 && i < 16) && ((j>=12 && j<=16)||(j>=32 && j<=36))) {
						pw.print("*");
					} else if ((i >= 26 && i <= 28) && ((j>=1 && j<=7)||(j>=20 && j<=28))) {
						if ((i == 26)&&(j > 1 && j < 7) || (i == 26)&&(j > 22 && j < 26) ) {
							pw.print("-");
						} else {
							pw.print("*");
						}
					}else {
						pw.print("-");
					}
				
								
			}
			pw.println();
		
		}
		}catch (IOException e) {
			System.out.println(e);
		}
			
		
	}
}
