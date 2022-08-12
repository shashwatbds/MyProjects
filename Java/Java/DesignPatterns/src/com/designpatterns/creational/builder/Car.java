package com.designpatterns.creational.builder;

public class Car {

	private String model;
	private String company;
	private int size;
	
	public Car(CarBuilder builder) {
		super();
		this.model = builder.getModel();
		this.company = builder.getCompany();
		this.size = builder.getSize();
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

	@Override
	public String toString() {
		return "Car [model=" + model + ", company=" + company + ", size=" + size + "]";
	}
	
}
