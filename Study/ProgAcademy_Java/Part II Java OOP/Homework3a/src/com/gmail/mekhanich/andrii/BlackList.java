package com.gmail.mekhanich.andrii;

public class BlackList {

	private Object[] blackList;

	public BlackList() {
		super();
		this.blackList = new Object[4];
	}

	public Object[] addTo(Object a) {
		Class sClass = a.getClass();
		int countNull = 4;
		int countClass = 0;
		for (int i = 0; i < blackList.length; i++) {
			if (blackList[i] != null) {
				countNull--;
				if (blackList[i].getClass() == sClass) {
					countClass++;
				}
			}
		}
		if (countNull > 0 && countClass == 0) {
			for (int j = 0; j < blackList.length; j++) {
				if (blackList[j] == null) {
					blackList[j] = a;
					break;
				}
			}
		} else {
			System.out.println("This Object already in list!" +"\n");
		}
		return this.blackList;
	}

	public boolean checkCLass(Object z) {
		int counter = 0;
		boolean chck = false;
		for (; counter < blackList.length - 1; counter++) {
			if (blackList[counter] == null) {
				continue;
			} else if (z.getClass() != blackList[counter].getClass()) {
				chck = true;
				continue;
			} else {
				chck = false;
				break;
			}
		}
		return chck;
	}

}
