package com.designpatterns.structural.decorator;

public class VegFood implements Food {

	@Override
	public String prepareFood() {
		// TODO Auto-generated method stub
		return "Veg Food";
	}

	@Override
	public double foodPrice() {
		// TODO Auto-generated method stub
		return 50.0;
	}

}
