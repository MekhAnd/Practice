package com.gmail.mekhanich.andrii;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.LongToIntFunction;

public class Main {

	public static void main(String[] args) {
		
		Calendar newOne = new GregorianCalendar(1955,11,02);
		long next = newOne.getTimeInMillis();
				
		LongToIntFunction date = Main::year;
		System.out.println(date.applyAsInt(next));

	}
	
	public static int year(long next) {
		Calendar b = Calendar.getInstance();
		b.setTimeInMillis(next);
		int year = b.get(Calendar.YEAR);
		return year;
	}
}
