package com.gmail.mekhanich.andrii;

public class IsNotFileExeption extends Exception {
	
	public String getMessage() {
		return "This is not file!" + System.lineSeparator();
	}
}