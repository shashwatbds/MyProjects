package com.java.practice.java.java8.Lambda;

@FunctionalInterface
public interface MyInterface {

	void abstractFunction(int x, int y);
	
	default void defaultMethod() {
		System.out.println("This is default method.");
	}
}
