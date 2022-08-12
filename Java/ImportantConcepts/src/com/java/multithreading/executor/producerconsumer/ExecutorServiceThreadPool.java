package com.java.multithreading.executor.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThreadPool {

	final BlockingQueue<Integer> queue=null;
	ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public void addThread(Runnable r) {
		executor.submit(r);
	}
	
	public void finish() {
		try {
			executor.shutdown();
			executor.awaitTermination(50, TimeUnit.SECONDS);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished all threads");
	}
}
