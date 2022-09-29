package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Faculty {

	private int quantity;
	private Object[] faculty;
	private int topElement;
	private BlackList bl;

	public Faculty(int quantity, BlackList bl) {
		super();
		this.quantity = quantity;
		faculty = new Object[quantity];
		this.topElement = -1;
		this.bl = bl;
	}

	public Faculty() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Object[] getFaculty() {
		return faculty;
	}
	
	

	@Override
	public String toString() {
		//String message = 
		return "Faculty [quantity=" + quantity + ", faculty=" + Arrays.toString(faculty) + ", topElement=" + topElement
				+ ", bl=" + bl + "]";
	}

	public boolean isFull() {
		if (this.quantity - 1 > this.topElement) {
			return false;
		} else {
			return true;
		}
	}

	public void setFaculty(Object group) {
		Class checkClsass = Group.class;
		if (this.bl.checkCLass(group) && !isFull()) {
			this.faculty[++topElement] = group;
			System.out.println("This " + faculty[topElement] + " was added!" +"\n"+"\n");
		} else {
			if (isFull()) {
				System.out.println("This faculty is overloaded"+ "\n");
			} else {
				
				System.out.println("This is not a Group, pls check parametrs of this Object!"+"\n");
			}
		}
	}

	public Object peekGroup() {
		Group peek = null;
		try {
			peek = ((Group) faculty[topElement]).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("CLONE OF PEEK GROUP IS DONE"+ "\n");

		return peek;
	}

	public Object popGroup() {
		Group pop = null;
		try {
			pop = ((Group) faculty[topElement]).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GROUP IS RETURN" + "\n");
		faculty[topElement] = null;
		topElement--;
		return pop;
	}

}
