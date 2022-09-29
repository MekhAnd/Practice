package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\HomeWork13StreamAPI_mapC\\www.txt");
		List<String> lines = new ArrayList<>();
		Stream<String> check;
		try {
			check = Files.lines(path)
					.filter(a->checker(a)==true);
					check.forEach(b->System.out.println(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean checker (String a) {
		boolean success = false;
		try {
			InetAddress url = InetAddress.getByName(a);
			success = url.isReachable(5000);
		} catch (UnknownHostException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return success;
	}

}
