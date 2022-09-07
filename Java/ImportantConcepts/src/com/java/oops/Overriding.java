package com.java.oops;

public class Overriding {

	public class A {
		public A(int i) {
			System.out.println(myMethod(i));
		}

		public int myMethod(int i) {
			return ++i + --i;
		}
	}
	
	class B extends A {
		
		public B(int i, int j) {
			super(i*j);
			System.out.println(myMethod(i*j));
		}
		
		int myMethod(int i, int j) {
			return myMethod(i*j);
		}
	}
	public static void main(String[] args) {
		Overriding o = new Overriding();
		B b = o.new B(12,21);
	}

}
