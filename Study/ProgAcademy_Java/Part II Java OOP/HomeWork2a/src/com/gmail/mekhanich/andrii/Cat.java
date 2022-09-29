package com.gmail.mekhanich.andrii;

public class Cat extends Animal {
	private String name;

	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Cat(String ration, String color, int weight) {
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
		return "Cat [name=" + name + "]";
	}

	@Override
	public String getVoice() {
		String voice = "meow, mrrrrr, meow";
		return voice;
	}

	@Override
	public void eat() {
		System.out.print("omnomnom");
	}

	@Override
	public void sleep() {
		System.out.println("mrrrrrrrrrrrmrrrrrrrrrrrrr");
	}

}
