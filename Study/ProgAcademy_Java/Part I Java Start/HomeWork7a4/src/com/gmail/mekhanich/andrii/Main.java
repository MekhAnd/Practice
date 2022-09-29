package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		// Вывести на экран 10 строк значения числа ПИ 
		
		for (int i=2; i<=11;i++) {
			String text = String.format("PI = %."+ i + "f" , Math.PI);
			System.out.println(text);
		}

	}

}
