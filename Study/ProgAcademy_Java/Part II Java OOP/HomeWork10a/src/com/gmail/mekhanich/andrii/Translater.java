package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Translater {
	private VocabularyUA vocabulary;
	private String[] textIn;
	private FileOperations sourse;
	private FileOperations dict;

	public Translater(VocabularyUA vocabulary, FileOperations sourse, FileOperations dict) {
		super();
		this.vocabulary = vocabulary;
		this.sourse = sourse;
		this.dict = dict;
	}

	public Translater() {
		super();
	}

	public VocabularyUA getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(VocabularyUA vocabulary) {
		this.vocabulary = vocabulary;
	}

	public String[] getTextIn() {
		return textIn;
	}

	public void setTextIn(String[] textIn) {
		this.textIn = textIn;
	}

	@Override
	public String toString() {
		return "Translater [vocabulary=" + vocabulary + ", textIn=" + Arrays.toString(textIn) + "]";
	}

	public void translator(VocabularyUA vocabulary) {
		String text = "";
		String res = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(this.sourse.getTextEn()))) {
			for (; (text = bfr.readLine()) != null;) {
				res += text;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] textIn = res.split(" ");
		text = "";
		for (int i = 0; i < textIn.length; i++) {
			text += (vocabulary.getDictionary()).get(textIn[i]) + " ";
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.sourse.getTextUa()))) {

			bw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
