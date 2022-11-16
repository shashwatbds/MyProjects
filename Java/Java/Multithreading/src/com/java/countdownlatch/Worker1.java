package com.java.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker1 extends Thread {

	private CountDownLatch cdl;
	
	public Worker1(CountDownLatch cdl) {
		super();
		this.cdl = cdl;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		this.cdl.countDown();
	}
}
