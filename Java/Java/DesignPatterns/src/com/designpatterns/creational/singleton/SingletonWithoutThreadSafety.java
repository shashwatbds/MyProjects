package com.designpatterns.creational.singleton;

import java.io.Serializable;

import javax.naming.OperationNotSupportedException;

public class SingletonWithoutThreadSafety implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static SingletonWithoutThreadSafety instance;
	
    private SingletonWithoutThreadSafety() throws OperationNotSupportedException {
    	if(instance !=null) {
    		throw new OperationNotSupportedException("Can't break singleton");// To save breaking singleton using reflection.
    	}
    }
    
    public static SingletonWithoutThreadSafety getInstance() throws OperationNotSupportedException {
    	if(instance == null) {
    		instance = new SingletonWithoutThreadSafety();
    	}
    	return instance;
    }
    
    public Object readResolve() throws OperationNotSupportedException { 
    	// prevent breaking singleton using deserialization.
    	//has to return Object rather than SingletonWithoutThreadSafety
    	return SingletonWithoutThreadSafety.getInstance();
    }
    

}
