package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Main {

	public static void main(String[] args) {
		String txt = "Reports that the sss Russians are moving qqq military hardware some 250 kilometers www from.";
				
		Predicate<String> pr = a->{
			if(a.matches(".*[aieuyo].*")) {
				return true;
			} else {
				return false;
			}
		};
		Collector<String, Map<String, Integer>, Map<String, Integer>> col = new WordMap(pr);
		Map<String, Integer> res = Arrays.stream(txt.split("\s")).collect(col);
		
		System.out.println(res);
		
	}

}

class WordMap<String> implements Collector<String, Map<String, Integer>, Map<String, Integer>> {
	Predicate<String> wordContains;

	public WordMap(Predicate<String> wordContains) {
		super();
		this.wordContains = wordContains;
	}

	@Override
	public Supplier<Map<String, Integer>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<String, Integer>, String> accumulator() {
		return (a, b) -> {
			if (wordContains.test(b)) {
				Integer q = a.getOrDefault(b, 0);
				a.put(b, q + 1);
			}
		};
	}

	@Override
	public BinaryOperator<Map<String, Integer>> combiner() {
		return (a, b) -> {
			Map<String, Integer> res = new HashMap<>();
			b.forEach((k, v) -> {
				Integer q = res.getOrDefault(k, 0);
				res.put(k, v + q);
			});
			return res;
		};
	}

	@Override
	public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
	}

}
