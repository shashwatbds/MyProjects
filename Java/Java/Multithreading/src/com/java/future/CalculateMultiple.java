package com.java.future;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculateMultiple {

	private AtomicInteger count = new AtomicInteger(1);
	private int num;

	public CalculateMultiple(int num) {
		super();
		this.num = num;
	}

	public int increment() {
		int multiple = count.getAndIncrement()*num;
		System.out.println(Thread.currentThread().getName()+" "+multiple);
		return multiple;
	}
}
