package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class TextSaver {
	private TextTransformer transformer;
	private File file;

	public TextSaver(TextTransformer transformer, File file) {
		super();
		this.transformer = transformer;
		this.file = file;
	}

	public TextSaver() {
		super();
	}

	public TextTransformer getTransformer() {
		return transformer;
	}

	public void setTransformer(TextTransformer transformer) {
		this.transformer = transformer;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "TextSaver [transformer=" + transformer + ", file=" + file + "]";
	}
	
	public void saveTextToFile(String text) {
		
		try (PrintWriter pw = new PrintWriter(file)) {
		 transformer.setText(text);
			String text2 = transformer.transform(text);
			
			pw.println(text2);			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
