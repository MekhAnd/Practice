package com.gmail.mekhanich.andrii;

import java.io.Serializable;

public class Human implements Serializable, Cloneable {
	private String name;
	private String lastName;
	private String gender;
	private int age;
	
	public Human(String name, String lastName, String gender, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}
	public Human() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
}
