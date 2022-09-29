package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		String txta = "The House January 6 investigation hoped to send a fear-inducing message deep into Donald Trump's inner circle by opening the way to the prosecution of Steve Bannon.";
		String txtb = "But the risks of that strategy became clear on Monday as the ex-President's political arsonist turned himself in to the FBI after a grand jury had indicted him for contempt of Congress last week. Ever the outsider wrecking ball, Bannon set the example for turning efforts to hold Trump acolytes accountable into fuel for more extremism.";
		String txtc = "2021/11/16 The House January 6 investigation hoped to send a fear-inducing message deep into Donald Trump's inner circle by opening the way to the prosecution of Steve Bannon.";
		
		
		List<String> list = new ArrayList<>();
		Consumer<String> con = a->{
			if(a.matches(".*[0-9].*")) {
				list.add(a);
			}
		};
		
		con.accept(txta);
		con.accept(txtb);
		con.accept(txtc);
		
		System.out.println(list);
	}

}
