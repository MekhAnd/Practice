package com.gmail.mekhanich.andrii;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {

	public static void main(String[] args) {
		String text ="Former President ������� ����� sa�d he was recently vi�ited at his ���� ���, �������, resort by Kyle Rittenhouse, the teena��er who was acquitted last week on all charges after fatally shooting two people and wounding a third during protests in Kenosha, Wisconsin, last summer.";
		String [] textar = text.split("\s");
		
		Stream <String> oneTxt = Arrays.stream(textar)
				.map(a ->a.replaceAll("[�-��-�]",""));
		List<String> result = oneTxt.collect(Collectors.toList());
		System.out.println(result);
		
		
		
//		Stream<Object> txt = text.chars()
//				.filter(a -> (a>96&&a<123||a>64&&a<91||a==32))
//				.mapToObj(a ->(char)a);
//		List<Object> res = txt.collect(Collectors.toList());
//		System.out.println(res);
		
	}

}
