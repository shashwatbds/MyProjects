package com.java.producerconsumer.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class PCWithWaitNotify {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxSize=10;
		
		Thread producer = new Producer(queue, maxSize, "Producer");
		Thread consumer = new Consumer(queue, maxSize, "Consumer");
		producer.start();
		consumer.start();
	}
}
