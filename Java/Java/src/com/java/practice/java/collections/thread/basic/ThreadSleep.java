package com.java.practice.java.collections.thread.basic;

public class ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread("Shashwat");
		mt.start();
		System.out.println("Before Sleeping...");
		try {
			Thread.sleep(1);// Causes main thread to sleep. To sleep user thread you need to add sleep in run method.
			Thread.sleep(1,5);// 1 nano secs 5 milli secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("After Sleeping...");
	}
}
