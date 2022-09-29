package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String text = "Global ttt stocks and U.S. index futures rose modestly as signs of a solid recovery in the world’s largest economy offset jitters over inflation and a faster tapering of Federal Reserve stimulus.";
		List<String> txt = new ArrayList<>(List.of(text.split("\s")));
		
		String vow = ".*[aiouyeAEIOUY].*";
		
		
		List<String> res = txt.stream()
				.filter(a-> a.matches(vow))
				.sorted((a,b)->(crack(a)-crack(b))*-1)
				.collect(Collectors.toList());
		
		System.out.println(res);
	}
	
	public static int crack (String a) {
		char [] ar = a.toLowerCase().toCharArray();
		int res = 0;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] == 'a'||ar[i] == 'e'|| ar[i] == 'i'|| ar[i] =='o'|| ar[i] == 'u'||ar[i] =='y') {
				res+=1;
			}
		}
		return res;
	}
}
