package com.java.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private AtomicInteger count = new AtomicInteger(0);
	private int num = 0;
	
	public void increment() {
		System.out.println("Normal Int "+num++);
		System.out.println("Atomic Integer "+count.getAndIncrement());
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Counter counter = new Counter();
		
		for(int i=0; i<100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					counter.increment();
				}
			}).start();
			//Thread.sleep(1000);
		}
	}
}
