package com.gmail.mekhanich.andrii;

public class Main {

	public static void main(String[] args) {
		Triangle one = new Triangle();
		one.setSideA(12);
		one.setSideB(12);
		one.setSideC(22);
		
		Triangle two = new Triangle(10,15,20);
		Triangle three = new Triangle(5,15,15);
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println();
		
		System.out.println("The area of triangle, is - " + String.format("%.2f", one.getArea()));
		System.out.println("The area of triangle, is - " + String.format("%.2f", two.getArea()));
		System.out.println("The area of triangle, is - " + String.format("%.2f", three.getArea()));
	}

}
