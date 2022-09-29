package com.gmail.mekhanich.andrii;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<Integer> listNumber = List.of(1, 2, 3, 4, 5);
		Function<Integer, String> keyMapper = a -> (a % 2 == 0) ? "even" : "odd";
		Function<Integer, String> valueMapper = a -> a.toString();
		BinaryOperator<String> mergeFunction = (a, b) -> a + ";" + b;

		Map<String, String> result = listNumber.stream()
				.collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));
		
		Stream<Entry<String, String>> ev = result.entrySet().stream().filter(a->a.getKey()=="even");
		Stream<Entry<String, String>> od = result.entrySet().stream().filter(a->a.getKey()=="odd");
		
		Optional<Entry<String, String>> first = ev.findFirst();
		Optional<Entry<String, String>> next = od.findFirst();
		
		String even =first.get().toString();
		String odd = next.get().toString();
		
		System.out.println(even + "\n" + odd);

	}

}
