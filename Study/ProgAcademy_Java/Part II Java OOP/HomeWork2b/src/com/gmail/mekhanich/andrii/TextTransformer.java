package com.gmail.mekhanich.andrii;

public class TextTransformer {
	private String text;

	public TextTransformer(String text) {
		super();
		this.text = text;
	}

	public TextTransformer() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TextTransformer [text=" + text + "]";
	}
	
	public String transform(String text) {
		text = text.toUpperCase();
		System.out.println(text);
		return text;
	}
}
