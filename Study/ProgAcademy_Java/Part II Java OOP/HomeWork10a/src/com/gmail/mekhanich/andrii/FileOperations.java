package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileOperations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VocabularyUA dictionary;
	private File vocabulary;
	private File textEn;
	private File textUa;
	
	
	
	public FileOperations() {
		super();
	}

	public FileOperations(VocabularyUA dictionary, File vocabulary) {
		super();
		this.dictionary = dictionary;
		this.vocabulary = vocabulary;
		}
	
	public FileOperations(File textEn, File textUa) {
		super();
		this.textEn = textEn;
		this.textUa = textUa;
	}

	public File getTextEn() {
		return textEn;
	}

	public void setTextEn(File textEn) {
		this.textEn = textEn;
	}

	public File getTextUa() {
		return textUa;
	}

	public void setTextUa(File textUa) {
		this.textUa = textUa;
	}

	public VocabularyUA getDictionary() {
		return dictionary;
	}

	public void setDictionary(VocabularyUA dictionary) {
		this.dictionary = dictionary;
	}

	public File getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(File vocabulary) {
		this.vocabulary = vocabulary;
	}

	@Override
	public String toString() {
		return "FileOperations [dictionary=" + dictionary + ", vocabulary=" + vocabulary + "]";
	}

	public void saveVoc(VocabularyUA dictionary) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.vocabulary))) {
			oos.writeObject(dictionary);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ok!");
	}

	public VocabularyUA loadVoc() {
		System.out.println("Yes we are loaded!");
		VocabularyUA dictionary = new VocabularyUA();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.vocabulary))) {
			dictionary = (VocabularyUA) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return dictionary;
	}
}
