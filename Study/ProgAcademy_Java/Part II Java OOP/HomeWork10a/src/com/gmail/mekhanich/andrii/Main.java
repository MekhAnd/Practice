package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> engToUa = new HashMap<>();
		HashMap<String, String> engTo = new HashMap<>();
		
		File ua = new File("ua.txt");
		File en = new File("en.txt");
		File dict = new File("dictionary.txt");
		VocabularyUA first = new VocabularyUA(engToUa);
		FileOperations source = new FileOperations(en, ua);
		FileOperations voc = new FileOperations(first, dict);
		

		(first.getDictionary()).put("Darius", "����");
		(first.getDictionary()).put("escaped", "���");
		(first.getDictionary()).put("over", "�����");
		(first.getDictionary()).put("mountains", "����");
		(first.getDictionary()).put("on", "��");
		(first.getDictionary()).put("horseback,", "�����");
		(first.getDictionary()).put("leaving", "���������");
		(first.getDictionary()).put(",", ",");
		(first.getDictionary()).put("his", "���");
		(first.getDictionary()).put("spear", "����");
		(first.getDictionary()).put("in", "�");
		(first.getDictionary()).put("chariot.", "��������");
		(first.getDictionary()).put("But", "���");
		(first.getDictionary()).put("the", "��");
		(first.getDictionary()).put("Battle", "�����");
		(first.getDictionary()).put("of", "���");
		(first.getDictionary()).put("Issus", "���");
		(first.getDictionary()).put("was", "�����");
		(first.getDictionary()).put("serious", "���������");
		(first.getDictionary()).put("defeat", "��������");
		(first.getDictionary()).put("for", "���");
		(first.getDictionary()).put("Persians.", "�����");
		(first.getDictionary()).put("Enormous", "���������");
		(first.getDictionary()).put("numbers", "�������");
		(first.getDictionary()).put("died.", "��������");
		(first.getDictionary()).put("The", "ֳ");
		(first.getDictionary()).put("rest", "������");
		(first.getDictionary()).put("Persian", "�������");
		(first.getDictionary()).put("army", "��쳿");
		(first.getDictionary()).put("broke", "���������");
		(first.getDictionary()).put("into", "��");
		(first.getDictionary()).put(".", ".");
		(first.getDictionary()).put("small", "�������");
		(first.getDictionary()).put("groups,", "�����");
		(first.getDictionary()).put("and", "�");
		(first.getDictionary()).put("most", "��������");
		(first.getDictionary()).put("hired", "��������");
		(first.getDictionary()).put("Greeks", "�����");
		(first.getDictionary()).put("sailed", "��������");
		(first.getDictionary()).put("home", "������");
		(first.getDictionary()).put("warships.", "��������� ��������");

		Set<String> a = (voc.getDictionary()).getDictionary().keySet();
		int i =0;
		for (String string : a) {
			
			System.out.print(i+". ");
			i++;
		}
		
		voc.saveVoc(first);
		
		first.addWord(voc);
		first.addWord(voc, "two", "���");
		
		Translater uaen = new Translater(first, source, voc);
		
		uaen.translator(first);
		voc.saveVoc(first);
		
		
		HashMap<String, String> finaEng = new HashMap<>();
		VocabularyUA therd = new VocabularyUA(finaEng);
		FileOperations vocFin = new FileOperations(therd, dict);
		
		vocFin.loadVoc();
		
		Set<String> z = vocFin.loadVoc().getDictionary().keySet();
		int k =0;
		for (String string : z) {
			System.out.println(k+". This is voc 3 ->" + string);
			k++;
		}
		
		vocFin.saveVoc(therd);
	}
	
}
