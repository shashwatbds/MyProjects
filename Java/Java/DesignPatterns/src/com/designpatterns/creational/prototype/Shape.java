package com.designpatterns.creational.prototype;

import java.util.Objects;

public abstract class Shape {

	private int x;
	private int y;
	private String color;

	public Shape() {
		super();
	}

	public Shape(Shape s) {
		super();
		if(Objects.nonNull(s)) {
			this.x = s.getX();
			this.y = s.getY();
			this.color = s.getColor();
		}
	}

	public abstract Shape clone();

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Shape)) return false;
		Shape shape2 = (Shape) object;
		return this.getX() == shape2.getX() && this.getY() == shape2.getY() && this.getColor().equals(shape2.getColor());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
