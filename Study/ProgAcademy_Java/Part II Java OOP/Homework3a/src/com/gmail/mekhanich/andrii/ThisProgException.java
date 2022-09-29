package com.gmail.mekhanich.andrii;

public class ThisProgException extends Exception {
	
	public String getMessage() {
		return "This group is full!" + System.lineSeparator();
	}

}