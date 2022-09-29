package com.gmail.mekhanich.andrii;

public class UpDownTransformer extends TextTransformer {
	private String text;
	
	public UpDownTransformer(String text) {
		super(text);
		}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "UpDownTransformer [text=" + text + "]";
	}

	@Override
	public String transform(String text) {
		char [] array = text.toCharArray();
		String newText = "";
		for (int i = 0; i <array.length; i++) {
			if (i % 2 == 0) {
				array[i] = Character.toUpperCase(array[i]);
				newText +=array[i];
			} else {
				array[i] = Character.toLowerCase(array[i]);
				newText +=array[i];
			}
		}
		System.out.println(newText);
		return newText;
	}
}
