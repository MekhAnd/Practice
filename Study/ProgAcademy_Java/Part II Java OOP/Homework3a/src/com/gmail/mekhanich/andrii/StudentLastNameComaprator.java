package com.gmail.mekhanich.andrii;

import java.util.Comparator;

public class StudentLastNameComaprator implements Comparator{
	
	@Override
	public int compare (Object a, Object b) {
		Student st1 = (Student) a;
		Student st2 = (Student) b;
		
		String lastNameS1 = st1.getLastName();
		String lastNameS2 = st2.getLastName();
		if (lastNameS1.compareTo(lastNameS2) > 0) {
			return 1;
		}
		if (lastNameS1.compareTo(lastNameS2) < 0) {
			return -1;
		}
		return 0;
	}
	

}