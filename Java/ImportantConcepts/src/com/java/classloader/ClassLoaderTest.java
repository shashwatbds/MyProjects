package com.java.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader(); // Assuming in class "MyClass"
		ClassLoaderTest obj = new ClassLoaderTest();
		ClassLoader classLoader2 = obj.getClass().getClassLoader();
		
		classLoader2.loadClass("com.java.classloader.ClassLoaderTest");
		
		Class obj2 = Class.forName("com.java.classloader.ClassLoaderTest");
		System.out.println(obj2.getName());
	}

}
