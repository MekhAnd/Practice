package com.gmail.mekhanich.andrii;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class VocabularyUA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> dictionary;
	private FileOperations vocabulary;

	public VocabularyUA() {
		super();
	}

	public VocabularyUA(HashMap<String, String> dictionary) {
		super();

		this.dictionary = dictionary;
	}

	public HashMap<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(HashMap<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public String toString() {
		return "VocabularyUA [dictionary=" + dictionary + "]";
	}

	public void addWord(FileOperations dict){
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> tmp =  (dict.getDictionary()).getDictionary();
		System.out.println("Would you like to add some words?");
		for(;true;) {
			System.out.println("Please input English word");
			String enWord = sc.nextLine();
			if (!enWord.equals("XXX")) {
				System.out.println("Please input Ukrainian meaning");
				String uaWord = sc.nextLine();
				System.out.println(tmp.put(enWord, uaWord));
			} else {
				tmp.put("exit", "вихід");
				break;
			}
		}
		System.out.println("Thank you!");
		(dict.getDictionary()).setDictionary(tmp);
		System.out.println("Have done!");
	}

	public void addWord(FileOperations dict, String en, String ua){
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> tmp =  (dict.getDictionary()).getDictionary();
		System.out.println(tmp.get("the"));
		tmp.put(en, ua);
		(dict.getDictionary()).setDictionary(tmp);
		}
}
