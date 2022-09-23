package com.test;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	
	private CountDownLatch cdl;
	
	public Worker(CountDownLatch cdl) {
		super();
		this.cdl = cdl;
	}

	@Override
	public void run() {
		System.out.println("Doing important work");
		cdl.countDown();
		System.out.println("Counted Down by thread "+Thread.currentThread().getName());
	}

}
