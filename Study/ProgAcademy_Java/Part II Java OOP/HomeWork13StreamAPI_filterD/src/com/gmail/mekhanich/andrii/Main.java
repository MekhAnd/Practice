package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String[] array = new String[] { "<dependency>", "<groupId>junit<groupId>", "<artifactId>junit<artifactId>",
				"<version>4.4</version>", "<scope>test</scope>", "</dependency>", "<dependency>",
				"<groupId>org.powermock</groupId>", "<artifactId>powermock-reflect</artifactId>",
				"<version>3.2</version>", "</dependency>" };
		Stream<String> res = Arrays.stream(array)
				.filter(a->a.contains("<groupId>"))
				.map(a -> a.replaceAll("<groupId>", ""))
				.map(a -> a.replaceAll("</groupId>", ""));
		List<String> result = res.collect(Collectors.toList());
		System.out.println(result);

	}

}
