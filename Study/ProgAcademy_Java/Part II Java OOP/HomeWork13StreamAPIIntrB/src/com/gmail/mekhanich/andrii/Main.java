package com.gmail.mekhanich.andrii;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// ��������� Stream API � List<Integer> �������� ������ �������� �����, ������������ �� 
		//�� ����������� � �������� � ����� ������.
		
		List<Integer> list = List.of(11, 12, 14, 0, 1, 7, 10, 9, 5, 3);
		Stream<Integer> numbers = list.stream()
				.filter(a -> a%2 != 0)
				.sorted((a,b) -> a.compareTo(b));
				
		List<Integer> resList = numbers.collect(Collectors.toList());
		System.out.println(resList);
	}

}
