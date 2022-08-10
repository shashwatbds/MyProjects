package com.designpatterns.structural.proxy;

public class RealInternetAccess implements OfficeInternetAccess{

	private String employeeName;
	
	public RealInternetAccess(String empName) {
		this.employeeName = empName;
	}
	
	
	@Override
	public void grantInternetAccess() {
		System.out.println("Access granted for employee: "+this.getEmployeeName());
		
	}

	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
