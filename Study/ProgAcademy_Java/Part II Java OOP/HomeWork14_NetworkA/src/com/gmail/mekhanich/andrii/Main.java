package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		String url = "https://fishki.net/";
		File list = new File("unordered links.txt");
		LinkChecked link = new LinkChecked(url);
		
		link.setFileWithHTML();
		Set<String> news = link.setSet();
		
		
		link.setCheckedList(news);
		link.setCheckedList(list);

	}

}
