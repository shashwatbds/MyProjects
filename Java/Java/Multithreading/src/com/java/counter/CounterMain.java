package com.java.counter;

public class CounterMain {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		CounterEven ce = new CounterEven(counter);
		CounterOdd co = new CounterOdd(counter);
		Thread t1 = new Thread(ce);
		Thread t2 = new Thread(co);
		t1.start();
		Thread.sleep(100);
		t2.start();
	}

}
