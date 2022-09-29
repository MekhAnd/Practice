package com.gmail.mekhanich.andrr;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Создать массив случайных чисел (длинна 15) и второй с длинной в два раза
		// большею Первые 15 элементов второго массива должны быть равны 15 элементам
		// первого следующие должны быть в 2 раза больше

		int arrOne[] = new int[15];							//declaring first array for 15 elements
		int arrTwo[];										//declaring first array

		for (int i = 0; i < arrOne.length; i++) {			//start cycle for filling
			arrOne[i] = (int) (Math.random() * 10);			
		}
		arrTwo = Arrays.copyOf(arrOne, 30);					//copy first array with increasing its size till 30
		for (int i = 15; i < arrTwo.length; i++) {			//start cycle for fill second array
			arrTwo[i] = arrTwo[i - 15] * 2;					
		}
		System.out.println("The first array is - " + Arrays.toString(arrOne)); // return results
		System.out.println("The second one is - " + Arrays.toString(arrTwo));
	}

}
