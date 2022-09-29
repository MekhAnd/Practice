package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Метод, который возвращает количество слов в строке

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your text below:");
		String text = sc.nextLine();

		System.out.println(countNumberOfWords(text));
	}

	public static int countNumberOfWords(String text) {
		String[] words = text.split(" ");
		return words.length;
	}

}
