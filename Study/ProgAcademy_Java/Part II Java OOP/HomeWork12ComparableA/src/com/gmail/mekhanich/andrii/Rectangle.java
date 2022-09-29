package com.gmail.mekhanich.andrii;

import java.util.Objects;


public class Rectangle implements Comparable<Rectangle> {
	
	private Double length;
	private Double width;
	private Double area;

	public Rectangle() {
		super();
	}

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
		this.area = this.length * this.width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", area=" + area + "]"+System.lineSeparator();
	}

	@Override
	public int hashCode() {
		return Objects.hash(area);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area);
	}

	@Override
	public int compareTo(Rectangle o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (this.area > o.area) {
			return 1;
		}
		if (this.area < o.area) {
			return -1;
		}
		else {
			Double one = (this.length+this.width)*2;
			Double two = (o.length+o.width)*2;
		return one.compareTo(two);
		}
	}
	
	<T extends Comparable<T>> T max(T[] array) {
		T max = array[0];
		for (int i = 1; i < array.length; i++) {
			if(array[i].compareTo(array[i-1])>0) {
				max = array[i];
			}
		}
		return max;
		
	}

}
