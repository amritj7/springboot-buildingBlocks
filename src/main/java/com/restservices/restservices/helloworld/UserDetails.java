package com.restservices.restservices.helloworld;

public class UserDetails {
	
	
	private String firstname;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String firstname, String lastname, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String lastname;
	private String city;
}
