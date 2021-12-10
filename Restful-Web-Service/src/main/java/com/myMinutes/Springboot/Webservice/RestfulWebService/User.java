package com.myMinutes.Springboot.Webservice.RestfulWebService;

import javax.validation.constraints.Size;

public class User {

	int ID;
	
	@Size(min = 2, message = "Name should have minimum 2 characters")
	String sName;
	
	public int getID() {
		return ID;
	}
	
	public User() {
		super();
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getsName() {
		return sName;
	}
	
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", sName=" + sName + ", toString()="
				+ super.toString() + "]";
	}
	
	public User(int iD, String sName) {
		super();
		ID = iD;
		this.sName = sName;
	}
	
	
	
}
