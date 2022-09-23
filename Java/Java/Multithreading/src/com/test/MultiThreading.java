package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MultiThreading {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
		Producer producer = new Producer(queue, 4);
		Consumer consumer = new Consumer(queue);
		es.submit(consumer);es.submit(producer);
		
		es.shutdown();es.awaitTermination(10, TimeUnit.SECONDS);
	}
}
