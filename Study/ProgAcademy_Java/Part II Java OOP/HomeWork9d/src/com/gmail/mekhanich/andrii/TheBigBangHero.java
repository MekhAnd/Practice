package com.gmail.mekhanich.andrii;

public class TheBigBangHero {

	private String name;

	public TheBigBangHero(String name) {
		super();
		this.name = name;
	}

	public TheBigBangHero() {
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
		return "TheBigBangHero [name=" + name + "]";
	}
	
	
}
