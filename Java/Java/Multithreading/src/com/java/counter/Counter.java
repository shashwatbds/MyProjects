package com.java.counter;

public class Counter {

	private boolean oddPrinted = false;

	public synchronized void printEven(int number) throws InterruptedException {

		while(!oddPrinted) {// Always call wait from inside a while loop not if loop
			wait();
		}
		System.out.println("Started by "+Thread.currentThread().getName()+" "+number);
		
		oddPrinted = false;
		notify();
	}

	public synchronized void printOdd(int number) throws InterruptedException {

		while(oddPrinted) {// Always call wait from inside a while loop not if loop
			wait();
		}
		System.out.println("Started by "+Thread.currentThread().getName()+" "+number);
		
		oddPrinted = true;
		notify();
	}
}
