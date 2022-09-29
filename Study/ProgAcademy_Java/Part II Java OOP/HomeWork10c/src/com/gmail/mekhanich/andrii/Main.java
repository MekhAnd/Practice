package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		ElementTypes<Integer> num = new ElementTypes<>();
		num.addElement(1);
		num.addElement(2);
		num.addElement(3);
		num.addElement(4);
		num.addElement(1);
		num.addElement(2);
		num.addElement(3);
		num.addElement(4);
		num.addElement(1);
		num.addElement(2);
		
		System.out.println(count(num));
		
		ElementTypes<Double> doubles = new ElementTypes<>();
		doubles.addElement(1.0);
		doubles.addElement(2.0);
		doubles.addElement(1.5);
		doubles.addElement(1.0);
		doubles.addElement(2.0);
		doubles.addElement(2.5);
		doubles.addElement(1.5);
		doubles.addElement(3.0);
		doubles.addElement(0.0);
		doubles.addElement(0.0);
		
		System.out.println(count(doubles));
		
		ElementTypes<String> strings = new ElementTypes<>();
		strings.addElement("text");
		strings.addElement("tax");
		strings.addElement("exit");
		strings.addElement("eight");
		strings.addElement("tax");
		strings.addElement("stop");
		strings.addElement("tap");
		strings.addElement("text");
		strings.addElement("String");
		strings.addElement("stop");
		
		System.out.println(count(strings));
		
		ElementTypes<Character> chars = new ElementTypes<>();
		chars.addElement('a');
		chars.addElement('z');
		chars.addElement('x');
		chars.addElement('c');
		chars.addElement('a');
		chars.addElement('s');
		chars.addElement('d');
		chars.addElement('z');
		chars.addElement('x');
		chars.addElement('x');
		
		System.out.println(count(chars));
		
		ElementTypes<Boolean> bool = new ElementTypes<>();
		bool.addElement(true);
		bool.addElement(true);
		bool.addElement(true);
		bool.addElement(true);
		bool.addElement(true);
		bool.addElement(true);
		bool.addElement(false);
		bool.addElement(false);
		bool.addElement(false);
		bool.addElement(false);
		
		System.out.println(count(bool));
		
			
	}
	
	public static <A>Map<Object, Integer> count(ElementTypes<A> array){ 	
		Object [] ar = new Object[10];
		ar = array.getArray();
		Map<Object, Integer> frq = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			int count = 0;
			for (int j = 0; j < ar.length; j++) {
				if (ar[j].equals(ar[i])) {
					count++;
				}
			}
			frq.put(ar[i], count);
			}
		return frq;
	}


}
