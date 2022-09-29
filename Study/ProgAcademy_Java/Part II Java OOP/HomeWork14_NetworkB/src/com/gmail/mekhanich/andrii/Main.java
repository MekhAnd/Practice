package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

	public static void main(String[] args) {
		
		
		try (ServerSocket soc = new ServerSocket(8080)) {
			for (;;) {
				Socket clisoc = soc.accept();
				System.out.println(clisoc.isConnected() + " " + clisoc.getInetAddress());
				Client cli = new Client(clisoc);
				
				System.out.println();
				
			}
		} catch (IOException e) {
			System.out.println("Error to server Socket Open!!!");
		}
	}

}
