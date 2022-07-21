package com.java.oops.polymorphism;

public class OverloadingTest {
	
	//1. Overloaded Method - Correct
	public void printData(String data) {
		System.out.println(data);
	}
	
	//2. Overloaded Method - Correct - changing parameter type is a valid signature change of method
	public void printData(int data) {
		System.out.println(data);
	}
	
	//3. Overloaded Method - Incorrect - changing return type is not a valid signature change of method
//	public int printData(String data) {
//		System.out.println(data);
//		return 0;
//	}
	
	//4. Overloaded Method - Correct - changing number of parameter is a valid signature change of method
	public void printData(String data1, String data2) {
		System.out.println(data1+data2);
	}
	
	//5. Overloaded Method - Correct - changing inheritance sequence of parameter is a valid signature change of method
	public void printData(Object data) {
		System.out.println(data);
	}
	
	//6. Overloaded Method - Incorrect - adding exception throws is not a valid signature change of method
//	public void printData(String data) throws Exception{
//		System.out.println(data);
//	}

	//7. Overloaded Method - Incorrect - changing visibility of method is not a valid signature change of method
//	private void printData(String data) {
//		
//	}
	
	//8. Overloaded Method - Incorrect - changing access specifier of method is not a valid signature change of method
//	public final void printData(String data) {
//		
//	}
//	public static void printData(String data) {
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
