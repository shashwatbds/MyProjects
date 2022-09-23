package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CDLExample {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch cdl = new CountDownLatch(4);
		ExecutorService es = Executors.newFixedThreadPool(4);
		for(int i=0; i<4; i++) {
			es.submit(new Worker(cdl));
		}
		cdl.await();
		es.shutdown();es.awaitTermination(1000, TimeUnit.SECONDS);
		
	}

}
