package com.designpatterns.creational.singleton;

public class SingletonUsingEnums {
	
	public static void main(String[] args) {
		SingletonEnum instance = SingletonEnum.INSTANCE;
		System.out.println(instance.getValue());
		instance.setValue(6);
		System.out.println(instance.getValue());
		
	}

}
