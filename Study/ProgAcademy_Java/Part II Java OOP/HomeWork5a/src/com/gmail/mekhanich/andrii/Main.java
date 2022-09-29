package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File in = new File("E:\\aaaaa\\");
		File out = new File("E:\\bbb\\");

		FileCompare first = new FileCompare("docx");
		
		
		try {
			FileOperations.fileCopy(in, out, first);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
