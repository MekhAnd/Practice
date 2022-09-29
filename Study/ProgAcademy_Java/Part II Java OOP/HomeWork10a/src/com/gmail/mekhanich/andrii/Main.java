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
		

		(first.getDictionary()).put("Darius", "Дарій");
		(first.getDictionary()).put("escaped", "утік");
		(first.getDictionary()).put("over", "через");
		(first.getDictionary()).put("mountains", "гори");
		(first.getDictionary()).put("on", "на");
		(first.getDictionary()).put("horseback,", "верхи");
		(first.getDictionary()).put("leaving", "залишивши");
		(first.getDictionary()).put(",", ",");
		(first.getDictionary()).put("his", "свій");
		(first.getDictionary()).put("spear", "спис");
		(first.getDictionary()).put("in", "у");
		(first.getDictionary()).put("chariot.", "колісниці");
		(first.getDictionary()).put("But", "Але");
		(first.getDictionary()).put("the", "ця");
		(first.getDictionary()).put("Battle", "битва");
		(first.getDictionary()).put("of", "при");
		(first.getDictionary()).put("Issus", "Іссі");
		(first.getDictionary()).put("was", "стала");
		(first.getDictionary()).put("serious", "серйозною");
		(first.getDictionary()).put("defeat", "поразкою");
		(first.getDictionary()).put("for", "для");
		(first.getDictionary()).put("Persians.", "персів");
		(first.getDictionary()).put("Enormous", "Величезна");
		(first.getDictionary()).put("numbers", "кількість");
		(first.getDictionary()).put("died.", "загинула");
		(first.getDictionary()).put("The", "Ці");
		(first.getDictionary()).put("rest", "рештки");
		(first.getDictionary()).put("Persian", "перської");
		(first.getDictionary()).put("army", "армії");
		(first.getDictionary()).put("broke", "розбилися");
		(first.getDictionary()).put("into", "на");
		(first.getDictionary()).put(".", ".");
		(first.getDictionary()).put("small", "невеликі");
		(first.getDictionary()).put("groups,", "групи");
		(first.getDictionary()).put("and", "і");
		(first.getDictionary()).put("most", "більшість");
		(first.getDictionary()).put("hired", "найнятих");
		(first.getDictionary()).put("Greeks", "греків");
		(first.getDictionary()).put("sailed", "відпливли");
		(first.getDictionary()).put("home", "додому");
		(first.getDictionary()).put("warships.", "військових кораблях");

		Set<String> a = (voc.getDictionary()).getDictionary().keySet();
		int i =0;
		for (String string : a) {
			
			System.out.print(i+". ");
			i++;
		}
		
		voc.saveVoc(first);
		
		first.addWord(voc);
		first.addWord(voc, "two", "два");
		
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
