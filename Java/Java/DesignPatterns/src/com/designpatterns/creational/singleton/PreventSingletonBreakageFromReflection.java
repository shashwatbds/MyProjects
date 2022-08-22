package com.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.naming.OperationNotSupportedException;

public class PreventSingletonBreakageFromReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, OperationNotSupportedException {
		SingletonWithoutThreadSafety instance = SingletonWithoutThreadSafety.getInstance();

		Constructor constructor = instance.getClass().getDeclaredConstructor(new Class[0]);// to make constructor visible
		constructor.setAccessible(true);

		SingletonWithoutThreadSafety instance2 = (SingletonWithoutThreadSafety) constructor.newInstance();// calling constructor

		if(instance == instance2) {
			System.out.println("Equal");
		} else {
			System.out.println("Different");
		}
	}
}
