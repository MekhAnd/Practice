package com.gmail.mekhanich.andrii;

import java.io.Serializable;
import java.util.Arrays;

public class Student extends Human implements CSVConverter, Serializable, Cloneable  {
	
	private String univer;

	public Student(String name, String lastName, String gender, int age, String univer) {
		super(name, lastName, gender, age);
		this.univer = univer;
	}
	

	public Student(String name, String lastName, String gender, int age) {
		super(name, lastName, gender, age);
	}

	public String getUniver() {
		return univer;
	}

	public void setUniver(String univer) {
		this.univer = univer;
	}
	
	@Override
	public String toString() {
		return "This Human ["+ getName() +" " +getLastName() + " is the Student of [univer=" + univer + "]" + "("+getAge() + " y.o., " + getGender() + ")]";
	}
	
	@Override
	public String toCSVString() {
		return getName() + ";" + getLastName() + ";" + getGender() + ";" + getAge() + ";" + getUniver();
	}
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public Student fromCSVString (String str) {
	 String [] newCSVStud = str.split(";");	
	 System.out.println(Arrays.toString(newCSVStud));
	 Student student = new Student(newCSVStud[0], newCSVStud[1], newCSVStud[2], Integer.parseInt(newCSVStud[3].trim()), newCSVStud[4]);
	 System.out.println(student);
	 return student;
	}
	
	
	
	
	
	

}
