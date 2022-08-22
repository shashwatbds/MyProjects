package com.designpatterns.creational.singleton;

import java.io.Serializable;

public class ThreadSafeSingleton implements Serializable{

	private ThreadSafeSingleton() {}
	
	private static class BillPughSingleton {
		private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
	}
	
	public static ThreadSafeSingleton getInstance() {
		return BillPughSingleton.INSTANCE;
	}
	//When the singleton class is loaded, inner class is not loaded and hence does not create object when loading class. 
	// Inner class is created only when getInstance( method is called. So it may seem like eager initialisation but it is lazy initialisation. 
	// Why this is thread safe ? static instance is thread safe.
}
