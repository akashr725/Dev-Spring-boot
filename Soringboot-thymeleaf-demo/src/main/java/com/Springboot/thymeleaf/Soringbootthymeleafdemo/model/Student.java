package com.Springboot.thymeleaf.Soringbootthymeleafdemo.model;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String checkBox;
	

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getCheckBox() {
		return checkBox;
	}


	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	
	

	

}
