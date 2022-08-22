package com.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonUsingReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
		
		Constructor constructor = instance.getClass().getDeclaredConstructor(new Class[0]);
		constructor.setAccessible(true);
		
		ThreadSafeSingleton instance2 = (ThreadSafeSingleton) constructor.newInstance();
		
		if(instance == instance2) {
			System.out.println("Equal");
		} else {
			System.out.println("Different");
		}
		
	}

}
