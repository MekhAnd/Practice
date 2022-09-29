package com.gmail.mekhanich.andrii;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		File looking = new File("vcredist_x86.exe");
		File where = new File ("J:\\Games\\");
		FileOperations one = new FileOperations(looking, where, 0, (where.listFiles()).length);
		File [] ar = where.listFiles();
		int length = 0;
		for (File file : ar) {
			if (file.isDirectory()) {
				length+=1;
			}
		}
		
		
		Executor ex = Executors.newFixedThreadPool(length);
		
		for (int i = 0; i < length; i++) {
			int start = (ar.length / length)*i;
			int stop = (ar.length / length) * (i + 1);
			if (ar.length % length!= 0 && i == (length - 1)) {
				stop = stop + ar.length % length;
			}
			ex.execute(new LookingThread(looking, where, one, start, stop));
		}
		
		
	}

}
