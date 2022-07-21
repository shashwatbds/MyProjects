package com.java.beans;

public class Employee {

	private String name;
	private int age;
	private double salary;
	private int dept;
	
	public Employee(String name, int age, int salary, int dept) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "My name is "+this.getName()+", I am "+this.getAge()+" years old and I am from "+this.getDept()+" department. My Salary is "+this.getSalary();
	}
	
	
}
