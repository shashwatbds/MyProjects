package com.java.atomicinteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private AtomicInteger count = new AtomicInteger(0);
	private int num = 0;
	
	public void increment() {
		num++;
		count.getAndIncrement();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Counter counter = new Counter();
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<1000; i++) {
			es.submit(()->counter.increment());
		}
		es.shutdown();
		es.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("Normal Int: "+counter.num+" Atomic Int: "+counter.count);
	}
}
