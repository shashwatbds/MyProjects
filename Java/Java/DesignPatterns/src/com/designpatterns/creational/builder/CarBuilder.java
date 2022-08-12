package com.designpatterns.creational.builder;

public class CarBuilder {

	private String model;
	private String company;
	private int size;

	public CarBuilder(String company) {
		this.company = company; // Only company name is mandatory to build a car.
	}

	public CarBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public CarBuilder size(int size) {
		this.size = size;
		return this;
	}
	
	public Car build() {
		return new Car(this);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
