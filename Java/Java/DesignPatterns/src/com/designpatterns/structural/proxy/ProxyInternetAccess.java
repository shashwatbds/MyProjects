package com.designpatterns.structural.proxy;

public class ProxyInternetAccess implements OfficeInternetAccess {

	private String employeeName;
	private RealInternetAccess realIAccess;
	
	public ProxyInternetAccess(String employeeName) {
		super();
		this.employeeName = employeeName;
	}


	@Override
	public void grantInternetAccess() {
		if(this.getRole(employeeName) > 4) {
			realIAccess = new RealInternetAccess(employeeName);
			realIAccess.grantInternetAccess();
		} else {
			System.out.println("Nahi Milega");
		}
	}
	
	public int getRole(String employeeName) {
		// write code to get details from database based on name and designation.
		return 9;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
