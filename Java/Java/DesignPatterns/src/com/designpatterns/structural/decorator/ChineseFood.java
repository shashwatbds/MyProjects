package com.designpatterns.structural.decorator;

public class ChineseFood extends FoodDecorator {

	public ChineseFood(Food newFood) {
		super(newFood);
		// TODO Auto-generated constructor stub
	}
	
	public String prepareFood() {
		return super.prepareFood()+" with fried rice and manchurian";
	}
	
	public double foodPrice() {
		return super.foodPrice()+65.0;
	}

}
