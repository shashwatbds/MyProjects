package com.java.oops.polymorphism;

import java.io.IOException;

public class OverridingTest extends OverridingTestParent{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//1. Correct Overriding - Exact Same method overridden
	@Override
	public void whoAmI() {
		// TODO Auto-generated method stub
		
	}

	//2. Correct Overriding - Exact Same method overridden, includes exception.
	@Override
	public void whoAmI2() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	//3. Incorrect Overriding - Overridden method can not throw a exception class of higher in hierarchy 
//	@Override
//	public void whoAmI2() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	//4. Incorrect Overriding - The overriding method can not reduce access of overridden method
//	@Override
//	protected void whoAmI3() {
//		// TODO Auto-generated method stub
//		
//	}
	 
	@Override
	public void whoAmI3() {
		// TODO Auto-generated method stub
		
	}

	//5. Correct Overriding - The overriding method can increase visibility of overridden method
	@Override
	public void whoAmI4() {
		// TODO Auto-generated method stub
		
	}
	
	//6. Correct Overriding - The overriding method can increase hierarchy of return type of overridden method
	@Override
	protected String whoAmI5() {
		// TODO Auto-generated method stub
		
		return "";
	}

	@Override
	protected String whoAmI6() {
		// TODO Auto-generated method stub
		return "";
	}

	//7.Incorrect Overriding - The overriding method can not return higher hierarchy of type of return of the overridden method
//	@Override
//	protected Object whoAmI6() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
