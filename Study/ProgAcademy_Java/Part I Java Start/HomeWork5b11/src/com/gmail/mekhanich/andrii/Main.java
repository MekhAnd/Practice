package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int array[][] = { 
				{ 1, 2, 3, 4, 5, 6 }, 
				{ 1, 2, 3, 4, 5, 6 }, 
				{ 1, 2, 3, 4, 5, 6 }, 
				{ 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, 
				{ 1, 2, 3, 4, 5, 6 }, };
		 	
		for (int i = 0; i < array.length / 2; i++) {
		        for (int j = i; j < array.length - i - 1; j++) {
		        	System.out.println("j= "+j);
		        	int temp = array[i][j];
		        	array[i][j] = array[array.length - 1 - j][i];
		            array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
		            array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
		            array[j][array.length - 1 - i] = temp;
		        
		            for (int[] row : array) {
						System.out.println(Arrays.toString(row));
					}
		        }
		    }
	
	}
}
