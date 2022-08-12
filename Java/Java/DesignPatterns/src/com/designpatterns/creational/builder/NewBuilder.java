package com.designpatterns.creational.builder;

public class NewBuilder {

	public static void main(String[] args) {
		CarBuilder cb = new CarBuilder("Toyota");
		Car c = cb.build();
		System.out.println(c);
		
		CarBuilder cb1 = new CarBuilder("Toyota");
		cb1.model("Etios").size(2);
		Car c1 = cb1.build();
		System.out.println(c1);
	}
}
