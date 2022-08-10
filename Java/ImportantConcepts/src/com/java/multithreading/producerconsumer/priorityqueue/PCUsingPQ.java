package com.java.multithreading.producerconsumer.priorityqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCUsingPQ {

	public static void main(String[] args) {
		//Create ABQ object with capacity 4
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(4);
		//Create 1 object each for producer and consumer
		Producer p = new Producer(bq);
		Consumer c = new Consumer(bq);
		
		Thread pt = new Thread(p);
		Thread pc1 = new Thread(c);
		Thread pc2 = new Thread(c);
		pt.start();pc1.start();pc2.start();
	}
}
