package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Main {

	public static void main(String[] args) {
		
		BiFunction<String, String, String[]> function = Main::counter;
		String a = "A group of House Democrats is introducing a resolution to censure Rep. Paul A. Gosar (R-Ariz.) for posting an altered, animated video that depicts him killing Rep. Alexandria Ocasio-Cortez (D-N.Y.) and swinging two swords at President Biden.";
		String b = "The resolution marks the latest Democratic backlash against Gosar over the video. On Tuesday, House Speaker Nancy Pelosi (D-Calif.) called for multiple investigations into Gosar’s posting of the video and urged House Minority Leader Kevin McCarthy (R-Calif.) to join in condemning the “horrific video.”";
		
		System.out.println(Arrays.toString(function.apply(a, b)));
	}
	public static String [] counter(String a, String b) {
		String [] a1 = a.split(" ");
		String [] b1 = b.split(" ");
				
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i<a1.length; i++) {
			for(int j=0; j<b1.length; j++) {
				if(a1[i].equals(b1[j])) {
					res.add(a1[i]);
				}
			}
		}
		String [] result = new String[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i]=res.get(i);
		}
		return result;
	}
}
