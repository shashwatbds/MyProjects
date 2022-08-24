package com.java.multithreading.cdlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

	private CountDownLatch latch;
	
	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" started execution");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.latch.countDown();
		System.out.println(Thread.currentThread().getName()+" counted down");
	}

}
