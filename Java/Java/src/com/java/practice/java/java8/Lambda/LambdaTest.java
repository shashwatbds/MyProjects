package com.java.practice.java.java8.Lambda;

/**
 * 1. Lambda Function is an anonymous function (function with no name and an identifier)
 * 2. They are defined at a place exactly where they are needed.
 * 3. They can also be referred as implementations of Functional Interfaces since they implement exactly one method.
 * 4.  They are functions that can be shared or referred to as an object.
 * */
public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyInterface fObj = (int x, int y) -> System.out.println(x+y);
		System.out.println("The result is -");
		fObj.abstractFunction(5, 5); //Implementing Abstract method in the functional interface.
		fObj.defaultMethod();
	}

}
