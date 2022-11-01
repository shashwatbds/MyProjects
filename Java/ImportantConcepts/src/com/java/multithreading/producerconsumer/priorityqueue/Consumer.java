package com.java.multithreading.producerconsumer.priorityqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> bq;

	// Initialize taken to -1 to indicate that no number has been taken so far
	int taken = -1;
	
	public Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}
	@Override
	public void run() {
		//Take numbers from the buffer and print them, if the last number taken is 4 then stop
		while(taken!=400) {
			try {
				taken = this.bq.take();
				System.out.println(taken+" Consumed by - "+Thread.currentThread().getName());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
