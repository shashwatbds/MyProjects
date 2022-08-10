package com.designpatterns.structural.proxy;

public class ProxyPatternClient {

	public static void main(String[] args) {
		OfficeInternetAccess oiAccess = new ProxyInternetAccess("Shashwat Bhardwaj");
		oiAccess.grantInternetAccess();
	}
}
