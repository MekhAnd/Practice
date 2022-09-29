package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String txt = "Reports that the Russians are moving military hardware some 250 kilometers from the border have raised eyebrows in Washington. And Ukrainian forces have deployed combat drones along the battle lines that separate them from pro-Russian separatists in the Donbas region.";
		String [] ar = txt.split("\s");
		
		
		Stream <String> flow  = (Stream<String>) Arrays.stream(ar);
		Set<String> text = flow.collect(Collectors.toSet());
		
		Predicate<String> pr = a -> a.length()>6;
		Collector<String, Set<String>, Set<String>> col = new WordSet(pr);
		Set<String> resultSet = text.stream().collect(col);
		System.out.println(resultSet);
	}

}

class WordSet implements Collector<String, Set<String>, Set<String>> {

	private Predicate<String> longWord;
	

	public WordSet(Predicate<String> longWord) {
		super();
		this.longWord = longWord;
	}

	@Override
	public Supplier<Set<String>> supplier() {
		return HashSet::new;
	}

	@Override
	public BiConsumer<Set<String>, String> accumulator() {
		return (a, b) -> {
			if (longWord.test(b)) {
				a.add(b);
			}
		};
	}

	@Override
	public BinaryOperator<Set<String>> combiner() {
		return (a, b) -> {
			Set<String> res = new HashSet<>();
			res.addAll(a);
			res.addAll(b);
			return res;
		};
	}

	public Function<Set<String>, Set<String>> finisher() {
		return (a) -> a;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Set.of();
	}
}
