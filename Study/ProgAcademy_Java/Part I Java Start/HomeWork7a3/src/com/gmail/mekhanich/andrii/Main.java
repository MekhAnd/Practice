	package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ¬вести с консоли число в бинарном формате, перевести в дес€тичный, вывести на экран
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your number in binary format:");
		//String numberBinary = sc.nextLine();
		int number = sc.nextInt(2);
		
		
		
		//binaryFormatter(numberBinary);  довше але можливо
		//binaryFormat (numberBinary);
		
		System.out.println(number);
	}
	
	
	
	/*public static void binaryFormatter (String a) {
		StringBuilder str = new StringBuilder(a);
		StringBuilder reverseA = str.reverse();
		
		String newA = reverseA.toString();
		
		char [] number = newA.toCharArray();
		int sum = 0;
		
		
		for (int i=0; i<number.length ; i++) {
			int var = Integer.parseInt(String.valueOf(number[i]));
			int varOne = ((int)Math.pow(2, i))* var;
			sum +=varOne;
			}
		
		System.out.println(sum);
		
	}
	
	public static void binaryFormat (String a) {
		System.out.println(Integer.parseInt(a,2));
	
		
	}*/

}
