package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MAin {

	public static void main(String[] args) {
		// Считать текст и вывести статистику по использованию букв в тексте
		// C:\Users\Andri\OneDrive\Робочий стіл\text.txt

		Scanner sc = new Scanner(System.in);
		System.out.println("Please, input the pass to your file:");
		String path = sc.nextLine();
		File textFile = new File(path);
		String text = loadTextFile(textFile);

		char[] array = (text.toLowerCase()).toCharArray();
		int[] charIndex = charIndexQ(array, text);
		// System.out.println(Arrays.toString(charIndexQ(array, text)));
		int maximum = maximumIn(charIndexQ(array, text));
		sortArray(charIndex, maximum);

	}
	
	//Method to calculating letters in text
	public static void sortArray(int[] a, int max) {
		int count = 0;
		for (; max >= 0;) {
			if (a[count] == max) {
				System.out.println(((char) (count + 97)) + " = " + max);
			}
			count++;
			if (count > 25) {
				count = 0;
				max--;
			}
		}
	}
	
	
	public static int[] charIndexQ(char[] a, String text) {
		int[] charIndex = new int[26];

		char[] alphabeth = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i <= alphabeth.length - 1; i++) {
			int count = 0;
			for (int j = 0; j <= a.length - 1; j++) {
				if (alphabeth[i] == a[j]) {
					count++;
				}
			}
			charIndex[i] = count;
		}

		return charIndex;
	}
	
	//Method to define maximum value in array
	public static int maximumIn(int[] a) {
		int max = 0;
		for (int i = 0; i <= a.length - 1; i++) {
			if (a[i] > max) {
				max = a[i];
			}

		}
		return max;

	}

	public static String loadTextFile(File file) {
		StringBuilder sbd = new StringBuilder();
		try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
			String textFromFile = "";
			for (; (textFromFile = bfr.readLine()) != null;) {
				sbd.append(textFromFile);
				sbd.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);

		}
		return sbd.toString();
	}

}
