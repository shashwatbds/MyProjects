package com.java.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CDLMain {

	public static void main(String[] args) {

		CountDownLatch cdl = new CountDownLatch(3);
		Worker1 worker1 = new Worker1(cdl);
		Worker1 worker2 = new Worker1(cdl);

		Worker1 worker3 = new Worker1(cdl);
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.submit(worker1);es.submit(worker2);es.submit(worker3);
		es.shutdown();
		try {
			es.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiting");
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
	}

}
