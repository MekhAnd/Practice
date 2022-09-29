package com.gmail.mekhanich.andrii;

import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Cat cat1 = new Cat("Luska", 5, "White");
		Cat cat2 = new Cat("Umka", 7, "Black");
		Cat cat3 = new Cat("Barsic", 2, "Red");
		Cat cat4 = new Cat("Luska", 3, "Grey");
		Cat cat5 = new Cat("Murzik", 9, "Wild");
		Cat cat6 = new Cat("Onix", 12, "Black");
		Cat cat7 = new Cat("Masiania", 7, "Grey");
		
		List<Cat> cats = List.of(cat1, cat2, cat3, cat4, cat5, cat6, cat7);
		
		Optional<String> nameCat = cats.stream()
				.map(a-> a.getName())
				.max((a,b) -> ((Integer)a.length()).compareTo(b.length()));
				
		
		System.out.println(nameCat);
	}

}
