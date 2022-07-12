package com.java.practice.java.java8.defaultmethods;

public class DafaultInterfaceAndStaticMethods {

	//Starting with Java 8, interfaces can have static and default methods that, 
	//despite being declared in an interface, have a defined behavior.
	public static void main(String[] args) {
		String producer = Vehicle.producer();
		
		VehicleImpl impl = new VehicleImpl();
		String overview = impl.getOverview();
		
		System.out.println(producer +" "+ overview);
	}
	
}
