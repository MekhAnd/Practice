package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		List <String> text = new ArrayList<>(List.of("demonstrate", "going", "this", "example", "September", "May", "Hello", "full", "Lamp", "superb"));
		Predicate<String> pred = a -> a.matches(".*[A-Z].*");
		Function<List<String>, String> fun = a ->{
			String result = "";
			for (int i = 0; i<a.size(); i++) {
				if(pred.test(a.get(i))){
					result= result + "\"" + (a.get(i))+ "\"" + System.lineSeparator();
				}
			}
			result +="null";
			return result;
		};	
		
		Supplier<String> solutionOne = new ListTxt(text,pred);
		System.out.println("First Solution: \n\n" + solutionOne.get()+"\n");
		
		Supplier<String> solutionTwo = ()-> fun.apply(text);
		System.out.println("Second Solution: \n\n" + solutionTwo.get());
		
		System.out.println();
		System.out.println("Third Solution: \n\n");
		
		BiFunction<List<String>, Integer, String> funTwo = (a,b) -> a.get(b);
		
		for (int i = 0; i<text.size(); i++) {
				if(pred.test(text.get(i))){
					System.out.println(funTwo.apply(text, i));
				}
		}
	}
	
	public static String word (List<String> a, int position) {
		Supplier<String> solutionThree = () ->a.get(position);
		return solutionThree.get();
	}
}

class ListTxt implements Supplier<String> {
	private List<String> list;
	private Predicate<String> pr;

	public ListTxt(List<String> text, Predicate<String> pr) {
		super();
		this.list = text;
		this.pr = pr;
	}

	@Override
	public String get() {
		String result = "";
		for (int i = 0; i<this.list.size(); i++) {
			if(this.pr.test(this.list.get(i))){
				result= result + "\"" + (list.get(i))+ "\"" + System.lineSeparator();
			}
		}
		result +="null";
		return result;
	}
	
	

}
