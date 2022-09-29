package com.gmail.mekhanich.andrii;

public class Dog extends Animal {
	String name;

	public Dog(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Dog(String ration, String color, int weight) {
		super(ration, color, weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

	@Override
	public String getVoice() {
		String voice = "WAF,WAF";
		return voice;
	}

	@Override
	public void eat() {
		System.out.print("MnumMnum");
	}

	@Override
	public void sleep() {
		System.out.println("Hrrrrrtpssssss,HHHRRRRRRRttttttpsssssss");
	}
}
