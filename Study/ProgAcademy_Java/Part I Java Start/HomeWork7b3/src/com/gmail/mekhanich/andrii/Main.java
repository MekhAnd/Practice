package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Определение минимального числа из ряда

		Scanner sc = new Scanner(System.in);
		String text = "";
		System.out.println("Please enter your row:");
		text = sc.nextLine();
		char[] rowArray = text.toCharArray();

		System.out.println(Arrays.toString(rowArray));
		System.out.println(calculating(row(rowArray)));
	}

	public static int[] row(char[] a) {
		int[] ar = new int[a.length];

		for (int i = 0; i <= a.length - 1; i++) {
			ar[i] = a[i] - 48; // ar[31-i] = Integer.parseInt(Integer.toString(ch[i],10));

		}
		System.out.println(Arrays.toString(ar));
		return ar;
	}

	public static String calculating(int[] a) {
		String res = "";
		int swch = 0;

		StringBuilder sbd = new StringBuilder();
		sbd.append(a[0]);
		for (int i = 0; swch != 0; i++) {
			if (a[i] != a[i + 1]) {
				System.out.println("i");
				sbd.append(a[i + 1]);
			} else {
				swch = 1;
			}
		}

		res = sbd.toString();
		return res;
	}

}
