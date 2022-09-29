package com.gmail.mekhanich.andrii;

public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	
	public Triangle(double sideA, double sideB, double sideC) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public Triangle() {
		super();
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}
	
	public double getArea() {
		double halfP = (sideA + sideB + sideC) / 2;
		double area = Math.sqrt(halfP * (halfP - sideA)* (halfP - sideB)* (halfP - sideC));
		
		return area;
	}
		
	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "]";
	}
	
	
	
	
}
