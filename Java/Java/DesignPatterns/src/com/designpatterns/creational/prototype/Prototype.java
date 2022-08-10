package com.designpatterns.creational.prototype;

public class Prototype {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.setRadius(5);
		c1.setX(10);
		c1.setRadius(6);
		c1.setColor("Blue");
		
		Circle c2 = (Circle) c1.clone();
	}
}
