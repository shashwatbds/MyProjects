package com.designpatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.naming.OperationNotSupportedException;

public class BreakSingletonUsingDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException, OperationNotSupportedException {
		ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
		try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream("Singleton.txt"))) {
			oStream.writeObject(instance);
		}
		try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream("Singleton.txt"))) {
			ThreadSafeSingleton instance2 = (ThreadSafeSingleton) iStream.readObject();
			
			if(instance == instance2) {
				System.out.println("Equal");
			} else {
				System.out.println("Different");
			}
		}
		SingletonWithoutThreadSafety sInstance = SingletonWithoutThreadSafety.getInstance();
		try (ObjectOutputStream oStream1 = new ObjectOutputStream(new FileOutputStream("SingletonReadresolve.txt"))) {
			oStream1.writeObject(sInstance);
		}
		try (ObjectInputStream iStream1 = new ObjectInputStream(new FileInputStream("SingletonReadresolve.txt"))) {
			SingletonWithoutThreadSafety sInstance2 = (SingletonWithoutThreadSafety) iStream1.readObject();
			
			if(sInstance == sInstance2) {
				System.out.println("Equal");
			} else {
				System.out.println("Different");
			}
		}
	}
}
