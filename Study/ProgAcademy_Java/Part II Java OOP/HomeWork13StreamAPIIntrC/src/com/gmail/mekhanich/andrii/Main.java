package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// ��������� Stream API ������� ����� ����� � ������������ �������� � �������� ��������.
		
		File fileList = new File("M:\\My new documents");
		//fileList.isFile()
		File [] files = fileList.listFiles();
		Optional<File> file =Arrays.stream(files)
				.filter(a -> a.isFile())
				.max((a,b) -> ((Long)a.length()).compareTo(b.length()));
						
		File res = file.get();
		System.out.println(res + "-" + res.length());

	}

}
