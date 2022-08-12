package com.designpatterns.structural.decorator;

public abstract class FoodDecorator implements Food {

	private Food newFood;
	
	public FoodDecorator(Food newFood) {
		this.newFood = newFood;
	}
	
	@Override
	public String prepareFood() {
		// TODO Auto-generated method stub
		return newFood.prepareFood();
	}

	@Override
	public double foodPrice() {
		// TODO Auto-generated method stub
		return newFood.foodPrice();
	}

}
