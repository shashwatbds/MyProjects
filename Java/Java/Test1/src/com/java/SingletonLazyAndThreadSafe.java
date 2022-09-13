package com.java;

public class SingletonLazyAndThreadSafe {

	private SingletonLazyAndThreadSafe () {}
	
	public static SingletonLazyAndThreadSafe getInstance() {
		return Inner.INSTANCE;
	}
	
	static class Inner {
		private static final SingletonLazyAndThreadSafe INSTANCE = new SingletonLazyAndThreadSafe();
	}
	public static void main(String[] args) {
		
	}

}
