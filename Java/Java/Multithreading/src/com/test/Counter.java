package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private int count;
	private AtomicInteger num = new AtomicInteger();
	
	
	public int getCount() {
		System.out.println("AtomicInteger is "+num+" while int is "+count);
		return this.count;
	}
	
	public void increment() {
		count++;
		num.getAndIncrement();
	}
}
