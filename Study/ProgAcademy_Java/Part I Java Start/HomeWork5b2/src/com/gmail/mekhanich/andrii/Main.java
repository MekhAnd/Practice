package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Код зеркального переворота массива (без использования дополнительного массива) = 8 минут
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the array length:");
		
		int parametr = sc.nextInt();					// take the array length
		int array[] = new int [parametr];				//declaring and initializing the array					
		

		for (int i = 0; i < parametr; i++) {			//filling our array
			array [i] = i+1;
							
		}
		System.out.println(Arrays.toString(array));		//return filled array
		
		
		
		for (int i = 0; i < array.length / 2; i++) {	//start cycle
			int zero = array [i];						//declaring zero variable for saving member of array which we relocating
			array [i] = array [array.length - 1 - i];	//first relocating - last member we save as first member 
			array [array.length - 1 - i] = zero;		//second relocating - first member which we save in zero (on first step) we save as last member 
			
		}
		
		System.out.println(Arrays.toString(array));		//return array
	
	}
}
