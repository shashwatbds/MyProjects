package com.designpatterns.structural.facade;

public class IPhone implements MobileShop{

	@Override
	public void modelNo() {
		// TODO Auto-generated method stub
		System.out.println("IPhone 6");
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("Rs 65000.00");
	}

	
}
