package com.gmail.mekhanich.andrii;


import java.util.Scanner;

public class KeyboardReader {
	
	
	Scanner sc = new Scanner(System.in);
	public Student setNewStudent () {
		
		Student n = new Student(null, null, null, 0, null);
		System.out.println("Please set up parametrs for new student:");
		System.out.println("The NAME, please:");
		n.setName(sc.nextLine());
		System.out.println("The LAST NAME, please:");
		n.setLastName(sc.nextLine());
		System.out.println("The GENDER, please (female/male):");
		n.setGender(sc.nextLine());
		System.out.println("The university, please:");
		n.setUniver(sc.nextLine());
		System.out.println("The AGE, please:");
		n.setAge(Integer.parseInt(sc.nextLine()));
		
		
		System.out.println(n);

		
		System.out.println("Thank you for your cooperation!");
		
		
		
		return n;
	}
	
	public String setSrchDelQuery () {
		
		System.out.println("Please enter the last name of student who you looking for:");
		String lastName = sc.nextLine();
		
		return lastName;
	}
	
	
	
	
	
	

}
