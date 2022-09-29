package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VerificationService {

	public boolean validateUser(String login, String pass) {
		boolean validation= false;
		
		
		for(String key: RegistrationServlet.getUserList().keySet()) {
			System.out.println(login + " " + "Get up login for validation");
			if(key.equals(login)) {
				if(((RegistrationServlet.getUserList()).get(key)).getPassword().equals(pass)) {
					validation = true; 
					break;
				}
			}
		}
		return validation;
		
	}
		
}
