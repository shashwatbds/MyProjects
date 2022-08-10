package com.designpatterns.creational.singleton;

public class SingletonWithoutThreadSafety {
	
	private static SingletonWithoutThreadSafety instance = null;
	
    private SingletonWithoutThreadSafety() {}
    
    public static SingletonWithoutThreadSafety getInstance() {
    	if(instance == null) {
    		instance = new SingletonWithoutThreadSafety();
    	}
    	return instance;
    }

}
