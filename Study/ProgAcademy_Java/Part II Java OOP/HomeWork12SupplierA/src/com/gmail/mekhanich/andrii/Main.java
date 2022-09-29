package com.gmail.mekhanich.andrii;

import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<String> one = new NextWord("With this example we are going to demonstrate how to convert");
		for (int i = 0; i<15; i++) {
			System.out.println(one.get());
		}
	}

}

	class NextWord implements Supplier<String> {
		private String text;
		private Integer position;
		private String[] array;

		public NextWord(String text) {
			super();
			this.text = text;
			this.position = 0;
			this.array = text.split("\\s");
		}

		@Override
		public String get() {
			String result = "";
			if (position <= array.length - 1) {
				result = array[position];
				position++;
			} else {
				position = 0;
				result = array[position];
				position++;
			}
			return result;
	}
}
