package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the array length:");
		int length = sc.nextInt();
		arrayGeneration(length);
	}

	public static void arrayGeneration(int a) { // ready
		int[] sequence = new int[a];
		int[] direction = new int[a];
		for (int i = 0; i <= a - 1; i++) {
			sequence[i] = i + 1;
			direction[i] = -1;
		}
		System.out.println(Arrays.toString(sequence));
		int maxMobElementPlase = maxMobElement(sequence, direction);
		for (;maxMobElementPlase!=-1;) {
			int mobElement = sequence[maxMobElementPlase];
			int nextIndex = maxMobElementPlase + direction[maxMobElementPlase];
			rotateMembers(sequence, direction, maxMobElementPlase, nextIndex);
			changeDirections(sequence, direction, mobElement);
			System.out.println(Arrays.toString(sequence));
			maxMobElementPlase = maxMobElement(sequence, direction);	
			}

	}
	public static void changeDirections (int [] sequence, int [] direction, int mobElement) {
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i]>mobElement) {
				direction[i] = direction[i] * -1;
			}
		}
	} 
	
	

	public static int maxMobElement(int[] sequence, int[] direction) {
		int index = -1;																//предполагаем что элемента нет
		for (int i = 0; i < sequence.length; i++) {									//запускаем массив для вычисления
			int nextNumber = i + direction[i];										//вычисляем индекс на который указывает проверяемый элемент
			if (nextNumber >= 0 && nextNumber < sequence.length) {					//если индекс больше 0 и менльше длинны последовательности 
				if (sequence[i]>sequence[nextNumber]) {								//если данный член последовательности больше следующего (того которого вычислили = nextNumber) а если меньше = else
					if (index == -1) {												//если индекс по прежнему равен - 1	
						index = i;													//меняем индекс на текущий - это место куда теперь встанет больший элемент
					} else {														
						if (sequence[i]>sequence[index]) {							// проверяем текущий элемент = если он больше предыдущего (перестановки уже происходили)
							index = i;												// тогда индекс следующей позиции = i!!!
						}
					}
				} 
			}
		}

		
		return index;
	}

	public static void rotateMembers(int[] subsequence, int[] direction, int old, int next) {

		int zero = subsequence[old];
		subsequence[old] = subsequence[next];
		subsequence[next] = zero;

		int one = direction[old];
		direction[old] = direction[next];
		direction[next] = one;
	}
}
