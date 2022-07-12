package com.java.algorithms;

public class EuclideanAlgorithm {
	
	public int findGCD(int a, int b) {
		int gcd = 1;
		while(a!=b) {
			if(a > b) {
				a = a-b;
			} else {
				b = b-a;
			}
		}
		if(a==b) {
			gcd = a;
		} 
		return gcd;
	}
		
	public static void main(String[] args) {
		EuclideanAlgorithm ea = new EuclideanAlgorithm(); 
		System.out.println(ea.findGCD(84,132));
		System.out.println(ea.findGCD(33,87));
		System.out.println(ea.findGCD(96,184));
		System.out.println(ea.findGCD(27,165));
	}

}
