package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class ElementTypes <A> {
	
	private A[] array = (A[]) new Object[10];
	private int counter = 0;
	
	public ElementTypes() {
		super();
	}

	public ElementTypes(A[] array, int counter) {
		super();
		this.array = array;
		this.counter = counter;
	}

	public A[] getArray() {
		return array;
	}

	public void setArray(A[] array) {
		this.array = array;
	}

	public int getCounter() {
		return counter;
	}


	@Override
	public String toString() {
		return "ElementTypes [array=" + Arrays.toString(array) + ", counter=" + counter + "]";
	}

	public void addElement (A element) {
		for (int i = 0; i < array.length; i++) {
			if(array[i]==null) {
				array[i]=element;
				this.counter++;
				return;
			}
		}
	}
	
}
