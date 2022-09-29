package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinkChecked {

	private String url;

	public LinkChecked(String url) {
		super();
		this.url = url;
	}

	public LinkChecked() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LinkChecked [url=" + url + "]";
	}
	
	/*
	 * Выгрузка HTML странички в текстовой файл
	 */
	
	public void setFileWithHTML (){
		StringBuffer sb = new StringBuffer();
		try {
			URL tmp = new URL(this.url);
			HttpURLConnection htmp = (HttpURLConnection) tmp.openConnection();
			BufferedReader bfr = new BufferedReader(new InputStreamReader(htmp.getInputStream(),"utf-8"));
			String html = "";
			for(;(html = bfr.readLine())!=null;) {
				sb.append(html).append(System.lineSeparator());
			}
			String res = sb.toString();
			PrintWriter pw = new PrintWriter(new File ("readedLink.txt"));
			pw.print(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.out.println("Have Done!");
		
		}
	/*
	 * Преобразование текстового файла (с HTML страницей) в список Set и
	 * создание текстового файла с тем же списком 
	 */
	
	public Set <String> setSet(){
		Set<String> setURLs = new HashSet<>();
		File source = new File("readedLink.txt");
		StringBuffer sb = new StringBuffer();
		String res = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(source))) {
			String text = "";
			for(;(text = bfr.readLine())!=null;) {
				sb.append(text).append(System.lineSeparator());
			}
			res = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} 
							
		Stream<String> flow = (Stream<String>) (Arrays.stream(res.split("\n"))
				.map(a->a.trim())
				.flatMap(a->Arrays.stream(a.split("<a href=")))
				.flatMap(a->Arrays.stream(a.split(">")))
				.flatMap(a->Arrays.stream(a.split("href=")))
				.filter(a->{
					if (a.matches(".*https:.*") ){
						return true;
					} else {
						return false;
					}
				})
				.filter(a->{
					if (a.matches(".*\s.*") ){
						return false;
					} else {
						return true;
					}
				})
				.map(a->a.replace("\"", ""))
			
				);
		
		setURLs = flow.collect(Collectors.toSet());
		try (PrintWriter pw = new PrintWriter(new FileWriter("unordered links.txt")) ) {
			setURLs.stream().forEach(a->pw.println(a));
			pw.flush();
		} catch (IOException e) {
			// TODO: handle exception
		}
				
		System.out.println("Unordered list of links has built!");
				
		System.out.println("You have Set now!");
		return setURLs;
	}
	
	/*
	 * Проверка ссылок (из списка) и создание файла с проверенным списком ссылок
	 */
	
	public void setCheckedList(Set<String> a) {
		int count = 0;
		try (PrintWriter pw = new PrintWriter(new FileWriter("checked links.txt"))) {
			
			for (String link : a) {
				URL tmp = new URL(link);
				HttpURLConnection htmp = (HttpURLConnection) tmp.openConnection();
				int chckCode = htmp.getResponseCode();
				if(chckCode>199&&chckCode<300) {
					pw.println(link);
					count++;
				} else {
					System.out.println("This link has some trouble:\n " + link+ "\n" + chckCode + "-was returned");
				}
				pw.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println(count + " links was added!");
		
	}
	
	/*
	 * Проверка ссылок (из файла) и создание файла с проверенным списком ссылок
	 */
	public void setCheckedList(File a) {
		FileOperations uns = new FileOperations(a);
		Set<String> b =uns.setReader();
		int count = 0;
		try (PrintWriter pw = new PrintWriter(new FileWriter("checked links.txt"))) {
			for (String link : b) {
				URL tmp = new URL(link);
				HttpURLConnection htmp = (HttpURLConnection) tmp.openConnection();
				int chckCode = htmp.getResponseCode();
				if(chckCode>199&&chckCode<300) {
					pw.println(link);
					count++;
				} else {
					System.out.println("This link has some trouble:\n " + link+ "\n" + chckCode + "-was returned");
				}
				pw.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println(count + " links was added!");
	}
	
}
