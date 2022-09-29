package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		// Дан массив - написать программу для подсчета нечетных цифр
		
		int count = 0;												//declaring variable for calculating
		int array[] = new int[] { 0, 5, 2, 4, 7, 1, 3, 19 };		//declaring array and enter the data
		for (int element:array) {									//starting for each cycle
			if (element % 2 !=0) {									//if our element is not divisible by 2 without rest 
				count+=1;											//count this element
			}
		}
		System.out.println(count);									//return result
	}

}
