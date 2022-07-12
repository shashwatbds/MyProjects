package com.java.practice.java.java8.methodreferences;

public class User {

	private String fName;
	private int age;
	private static String company = "JP Morgan";
	
	public static void userInfo() {
		System.out.println("I am a user of "+company);
	}
	
	public User(String fName, int age) {
		super();
		this.fName = fName;
		this.age = age;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public void introduceYourself() {
		System.out.println("Hello, My name is "+this.fName+" and I am "+this.age+" years old");
	}
}
