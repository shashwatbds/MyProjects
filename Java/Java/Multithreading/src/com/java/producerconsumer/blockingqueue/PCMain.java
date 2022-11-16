package com.java.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCMain {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(20);
		Producer producer = new Producer(queue, "Producer");
		Consumer consumer = new Consumer(queue,"Consumer");
		producer.start();consumer.start();
	}
}
