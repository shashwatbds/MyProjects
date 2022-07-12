package com.java.practice.java.java8.functionalinterfaces;

/**
 * 1. This is usually for compiler level errors.
 * 2. It allows exactly one abstract method. Not more not less.
 * 3. If you don't add annotation then it would still work but this is to inform compiler 
 * 		that the interface will have only one abstract method.
 * 4. You can add as many default methods are you like to in a functional interface since 
 * 		they are considered to be non-abstract. Default Methods only exist in Interface not in 
 * 		implementation of interface.
 * 		The Default methods can be overridden but they can't be declared as default in implementations.
 * 5. If an interface has an abstract method that overrides one of the public methods of "java.lang.object" 
 * 		then it is not considered as interface's abstract method.
 * */
@FunctionalInterface
public interface MyFirstFunctionalInterface {
	public void firstWork(); // Only this one is considered as abstract method of this class.
	
	@Override
	public String toString();
	
	@Override
	public boolean equals(Object o);
	
	public default String defaultMethod() {
		return "I am default Method";
	}
	
	public default String defaultMethod1() {
		return "I am default Method1";
	}
}
