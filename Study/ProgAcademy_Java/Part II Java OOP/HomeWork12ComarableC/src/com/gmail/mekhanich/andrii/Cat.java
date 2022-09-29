package com.gmail.mekhanich.andrii;

import java.util.Objects;

public class Cat implements Comparable<Cat>{

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(name, other.name);
	}
	
	//(this.length).compareTo(o.length)
	
	@Override
	public int compareTo(Cat o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (this.name.length() > o.name.length()) {
			return 1;
		}
		if (this.name.length() < o.name.length()) {
			return -1;
		}
		else {
		return this.age.compareTo(o.age);
		}
	}
	
	
	

}