package com.designpatterns.structural.decorator;

public class NonVegFood extends FoodDecorator {

	public NonVegFood(Food newFood) {
		super(newFood);
	}

	@Override
	public String prepareFood() {
		// TODO Auto-generated method stub
		return super.prepareFood()+" with roasted chicken and curry";
	}

	@Override
	public double foodPrice() {
		// TODO Auto-generated method stub
		return super.foodPrice()+150.0;
	}

}
