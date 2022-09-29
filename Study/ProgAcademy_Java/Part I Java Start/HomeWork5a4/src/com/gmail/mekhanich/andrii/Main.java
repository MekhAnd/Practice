package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ¬вести строку текста и посчитать колчество символов "b"
		Scanner sc = new Scanner(System.in);							//declaring the scanner
		System.out.println("Please enter text below:");					//ask user to enter the text
		String text = sc.nextLine();									//take this text
		int count = 0;													//declaring variable which calculating 

		char[] arrChar = text.toCharArray();							//converting text from String to array
		//System.out.println(Arrays.toString(arrChar));
		for (int i = 0; i < arrChar.length; i++) {						//start the cycle
			if (arrChar[i] == 'b' || arrChar[i] == 'B') {				//if meet these chars
				count++;												//calculate them
			}
		}
		System.out.println("This text contains 'b' and 'B' - " + count + " so many times!");		//return result
	}

}
