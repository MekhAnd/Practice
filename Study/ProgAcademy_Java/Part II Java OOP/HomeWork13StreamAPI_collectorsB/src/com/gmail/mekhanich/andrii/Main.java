package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// Реализуйте файловый классификатор по размеру файлов.

		File folder = new File("F:\\Music\\Linkin Park - Коллекция [FLAC] [WEB]\\Albums\\Linkin Park - 2014 - The Hunting Party (Acapellas + Instrumentals)\\");
		Function<File, String> keyMapper = a -> (checker(a));
		Function<File, List<String>> valueMapper = a -> List.of(a.getName());

		BinaryOperator<List<String>> mergeFunction = (a, b) -> {
			List<String> tmp = new ArrayList<>(a);
			tmp.addAll(b);
			return tmp;
		};

		Supplier<Map<String, List<String>>> supplier = HashMap::new;

		Map<String, List<String>> res = Arrays.stream(folder.listFiles())
				.collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));

		System.out.println(res);

	}

	public static String checker(File a) {
		long size = a.length();
		String res = "";
		if (size < 2_000_000) {
			res = "Small";
		} else if (size < 8_000_000) {
			res = "Normal";
		} else if (size < 12_000_000) {
			res = "Bigger than Normal";
		} else if (size < 20_000_000) {
			res = "Big";
		} else {
			res = "Enourmous";
		}

		return res;
	}

}
