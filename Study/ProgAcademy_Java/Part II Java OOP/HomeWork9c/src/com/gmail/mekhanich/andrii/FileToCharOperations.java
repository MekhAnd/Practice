package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileToCharOperations {

	private File file;

	public FileToCharOperations() {
		super();
	}

	public FileToCharOperations(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileToCharOperations [file=" + file + "]";
	}

	public char[] readerTo() {
		String text = "";
		String res = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(this.file))) {
			for (; (text = bfr.readLine()) != null;) {
				res += text;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException o) {
			o.printStackTrace();
		}
		res.toLowerCase();
		char[] array = res.toCharArray();
		
		//System.out.println(Arrays.toString(array));

		return array;
	}

	public void counter () {
		List<Character> charBuff = new ArrayList<>();
		for(int i = 0;i < readerTo().length;i++ ) {
			charBuff.add(i, readerTo()[i]);
		}
		char[] abc = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		
		
		int[] charIndex = new int[26];
		for (int i = 0; i < abc.length; i++) {
			int count=0;
			for (int j = 0; j < charBuff.size(); j++) {
				if (abc[i]==charBuff.get(j)) {
					count++;
				}
			}
			charIndex[i]=count;
		}
		int max = charIndex[0];
		for (int i = 0; i < charIndex.length; i++) {
			if(charIndex[i]>max) {
				max = charIndex[i];
			}
		}
		int count=0;
		for (;max>=0;) {
			if (charIndex[count]==max) {
				System.out.println((char)(count+97) +" - mentioned " + max + " times");
			}
			count++;
			if (count > 25) {
				count = 0;
				max--;
			}
			
		}
		
	}
}
