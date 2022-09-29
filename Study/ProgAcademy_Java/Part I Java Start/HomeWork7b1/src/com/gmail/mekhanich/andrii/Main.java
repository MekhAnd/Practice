package com.gmail.mekhanich.andrii;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ¬вести с консоли дату, —равнить ее с текущей датой в системе и вывести отличающиес€ части на экран
		
		Scanner sc = new Scanner(System.in);
		String textDate = "";
		Date dateNow = new Date();		
		
		System.out.println("Please enter your day (DD): ");
		int day = sc.nextInt();
		System.out.println("Please enter your month (MM): ");
		int month = sc.nextInt();
		System.out.println("Please enter your mounth (YYYY): ");
		int year = sc.nextInt();
		
		Calendar clOne = Calendar.getInstance();
		clOne.set(year, (month-1), day);
		Calendar clTwo = Calendar.getInstance();
		clTwo.setTime(dateNow);
		System.out.println("Here are the differences between these dates:");
		
		if (clOne.get(Calendar.DATE)!=clTwo.get(Calendar.DATE)) {
			System.out.println("- the date is differs on " + (clOne.get(Calendar.DATE)-clTwo.get(Calendar.DATE)) + " days " + clOne.get(Calendar.DATE));
		}
		if (clOne.get(Calendar.MONTH)!=clTwo.get(Calendar.MONTH)) {
			System.out.println("- the date is differs on " + (clOne.get(Calendar.MONTH)-clTwo.get(Calendar.MONTH)) + " mounth " +  (clOne.get(Calendar.MONTH)+1));
		}
		if (clOne.get(Calendar.YEAR)!=clTwo.get(Calendar.YEAR)) {
			System.out.println("- the date is differs on " + (clOne.get(Calendar.YEAR)-clTwo.get(Calendar.YEAR)) + " years " + clOne.get(Calendar.YEAR));
		}
	}

	
}
