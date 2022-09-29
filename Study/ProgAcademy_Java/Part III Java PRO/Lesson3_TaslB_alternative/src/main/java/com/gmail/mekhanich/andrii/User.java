package com.gmail.mekhanich.andrii;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String name;
	private String nickName;
	private String login;
	private String password;
	private String gender;
	private Boolean present;
	private String role;
	
	
	public User(String name, String nickName, String login, String password, String gender,String role) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.login = login;
		this.password = password;
		this.gender = gender;
		this.role = role;
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Boolean getPresent() {
		return present;
	}


	public void setPresent(Boolean present) {
		this.present = present;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", nickName=" + nickName + ", login=" + login + ", password=" + password
				+ ", gender=" + gender + ", present=" + present + "]";
	}


	
	
	
	
	
	

}
