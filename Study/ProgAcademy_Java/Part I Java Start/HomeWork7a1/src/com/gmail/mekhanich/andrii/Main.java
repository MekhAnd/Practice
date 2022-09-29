package com.gmail.mekhanich.andrii;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// Кол-во миллисекунд, прошедших с такого же числа прошлого месяца
		
		Date dateNow = new Date();
		Calendar cl = Calendar.getInstance();
		Calendar clExDate = Calendar.getInstance();
		cl.setTime(dateNow);
		
		int mounth = cl.get(Calendar.MONTH);
		int mounthEx = mounth - 1;
		clExDate.set(Calendar.MONTH, mounthEx);
				
		Date dateMounth = clExDate.getTime();
		long dif =  dateNow.getTime() - dateMounth.getTime(); 
						
		System.out.println(dif);
		
		
		

		SimpleDateFormat formatDateDay = new SimpleDateFormat("dd.M.yyyy");
		
		String resDay = formatDateDay.format(dateMounth);
		String resEx = formatDateDay.format(dateNow);
		System.out.println(resDay + "." + resEx);

	}

}
