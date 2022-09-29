package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// »спользу€ Stream API верните адрес файла с максимальным размером в заданном каталоге.
		
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
