package com.gmail.mekhanich.andrii;

public class Cat {
	private String name;
	private int weight;
	private String color;

	public Cat(String name, int weight, String color) {
		this.name = name;
		this.weight = weight;
		this.color = color;
	}

	public Cat() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Cat [name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}
	

	
}