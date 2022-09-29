package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat leo = new Cat("Fish", "Black", 5, "Leonardo");
		Dog gec = new Dog("Meat", "Black", 55, "Gecktor");
		Veterenarian doc = new Veterenarian("Doctor");
		
		
		
		Animal one = gec;
		doc.treatment(one);
		
		
		
		}

}
