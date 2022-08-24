package com.java.multithreading.cdlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Thread t1 = new Thread(new Worker(latch));
		Thread t2 = new Thread(new Worker(latch));
		Thread t3 = new Thread(new Worker(latch));
		t1.start();t2.start();t3.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Await done");
	}
}
