package com.java.atomicinteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter1 {

	private AtomicInteger atomicCounter = new AtomicInteger();
	private int count = 0;

	public void increment() {
		atomicCounter.getAndIncrement();
		count++;
	}

	public static void main(String[] args) {

		final Counter1 counter = new Counter1();
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<1000; i++) {
			es.submit( () -> counter.increment() );
		}
		es.shutdown();
		try {
			es.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Normal Int: "+counter.count+" Atomic Int: "+counter.atomicCounter);
	}
}
