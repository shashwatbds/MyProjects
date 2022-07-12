package com.java.practice.java.java8.defaultmethods;

public interface Vehicle {
	
	// Accessible with Interface name only.
	// It can't be overridden by an implementing class - because it's static
	static String producer() {
		return "Tata Motors";
	}
	
	// Accessible only using implementation class objects.
	// Possible to override this method.
	// It provides an implementation of methods within interfaces enabling 'Interface
	// evolution' facilities.
	default String getOverview() {
		return "Nexo is made by" + producer();
	}
	
}
