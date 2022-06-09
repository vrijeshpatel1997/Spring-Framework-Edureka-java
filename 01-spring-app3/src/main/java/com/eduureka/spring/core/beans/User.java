package com.eduureka.spring.core.beans;

public class User {

	
	private String firstName;
	private String lastName;
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println();
		System.out.println("---------------two  argument constructor------------");
	}
	public User() {
		super();
		System.out.println("---------------zero argument constructor------------");
		
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public String getFirstName() {
		System.out.println("---------------inside  getFirstName()method------------");
		return firstName;
		
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("---------------inside  setFirstName()method------------");
	}
	public String getLastName() {
		System.out.println("---------------inside getLastName()method------------");
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("---------------inside  setLastName()method------------");
	}
}
