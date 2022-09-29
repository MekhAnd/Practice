package com.gmail.mekhanich.andrii;

import java.util.Objects;

public class Cat {

	private String name;
	private Integer age;

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}