package com.gmail.mekhanich.andrii;

public class InverseTransformer extends TextTransformer {
	private String text;
	
	public InverseTransformer(String text) {
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
		return "InverseTransformer [text=" + text + "]";
	}

	@Override
	public String transform(String text) {
		char [] array = text.toCharArray();
		String newText = "";
		for (int i = array.length-1; i >= 0; i--) {
			newText += array[i];
		}
		System.out.println(newText);
		return newText;
	}
}
