package com.gmail.mekhanich.andrii;

public class Veterenarian {
	private String name;

	public Veterenarian(String name) {
		super();
		this.name = name;
	}

	public Veterenarian() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Veterenarian [name=" + name + "]";
	}

	public void treatment(Animal animal) {
		System.out.print("I try treating my new patient, ");
		System.out.print(animal.toString());
		System.out.print(" but he tries to ");
		animal.sleep();
		System.out.print("I think he sleeps because he ");
		animal.eat();
		System.out.print(" a lot of " + animal.getRation());
		
	}
}
