package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Перевернуть массив по часовой стрелке на 90, 180, 360 градусов без
		// использования второго массива

		int array[][] = { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, };
		int counti = 0;
		for (int i = 0; i < array.length /2; i++) {
			

			for (int j = i; j < array.length- i - 1; j++) {

				int zero = array[i][j];
				array[i][j] = array[array.length - 1 - j][i];
	            array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
	            array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
	            array[j][array.length - 1 - i] = zero;
			}
		}
		for (int[] row : array) {
			System.out.println(Arrays.toString(row));
			}

	}

	
	
	
	
	
	// for (int[] row : array) {
	// System.out.println(Arrays.toString(row));
	// }
}


/*int three = array[array.length - 1 - i][j];

array[i][j] = three;
array[i][array.length -j- 1] = zero;
array[array.length - i - 1][array.length - j - 1] = one;
array[array.length - i - 1][j] = two;
*/

//System.out.println(zero+" " +one + " " + two + " " + three);


/*
 * for (int i = 0; i < array.length; i++) { for (int j = 0; j < array.length;
 * j++) { array[i][j] = j + 1; } }
 */

/*
 * zero = array[i][j]; //0;0 one = array [i][array.length - j - 1]; //0;5 two =
 * array[array.length - i - 1][array.length - j - 1]; //5;5 three =
 * array[array.length - i - 1][j]; //5;0 four = array[i][array.length - count];
 * //0;1
 */

// System.out
// .println("i= " + i + "j = " + j + " " + tmpZero + " " + tmpOne + " " + tmpTwo
// + " " + tmpThree);

/*
 * array[i][j] = three; array [i][array.length - j - 1] = four;
 * array[array.length - i - 1][array.length - j - 1] = two; array[array.length -
 * i - 1][j] = two; array[i][array.length - count] = zero;
 */

// System.out.println("i= " + i + "j = " + j + " " + array[i][j] + " " +
// array[i][array.length - j - 1]
// + " " + array[array.length - i - 1][array.length - j - 1] + " "
// + array[array.length - i - 1][j]);

// for (int[] row : array) {
// System.out.println(Arrays.toString(row));
// }

/*
 * tmpOne = array [i][array.length - j-1]; tmpTwo = array [array.length -
 * i-1][j];
 * 
 * System.out.println(tmpOne + " что вырезаем" + tmpTwo + " что вставляем");
 * 
 * array [i][array.length - j-1] = tmpTwo; array [array.length - i-1][j] =
 * tmpOne;
 */