package com.designpatterns.structural.facade;

public class Shopkeeper {

	private MobileShop iphone;
	private MobileShop samsung;
	private MobileShop blackberry;
	
	public Shopkeeper() {
		super();
		this.iphone = new IPhone();
		this.samsung = new Samsung();
		this.blackberry = new Blackberry();
	}
	
	public void iPhoneSale() {
		this.iphone.modelNo();
		this.iphone.price();
	}
	
	public void samsungSale() {
		this.samsung.modelNo();
		this.samsung.price();
	}
	
	public void blackberrySale() {
		this.blackberry.modelNo();
		this.blackberry.price();
	}
	
}
