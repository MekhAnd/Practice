package com.gmail.mekhanich.andrii;

public interface CSVConverter {
	public String toCSVString();
	public Student fromCSVString (String str);
}
