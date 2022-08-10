package com.designpatterns.creational.prototype;

import java.util.Objects;

public class Circle extends Shape {

	public int radius;
	
	public Circle() {
		
	}
	public Circle(Circle target) {
		super(target);
		if(Objects.nonNull(target)) {
			this.radius = target.radius;
		}
	}
	
	@Override
	public Shape clone() {
		// TODO Auto-generated method stub
		return new Circle(this);
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public int hashCode() {
		return Objects.hash(radius);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return radius == other.radius;
	}

	
}
