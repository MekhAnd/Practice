package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		
		 //Вывести простые числа от 1 до 100
		
		for (int i = 2; i <= 100; i++) {    // start cycle
			int count = 0;					//declaring variable for count quantity of divisions
			for (int j = 1; j<=100; j++) {	//start inner cycle for division every number from outer cycle 
				if (i % j == 0) {			// if we can divide number without rest 
					count +=1;				// count this
					
				} 
			} if (count <= 2) {				// if count less than 2 
				System.out.println(i);		//print this number
			}
		}

	}

}
