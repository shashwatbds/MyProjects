package com.java.multithreading.producerconsumer.priorityqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> bq;
	
	public Producer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {

		for(int i=0; i<400; i++) {
			try {
				this.bq.put(i);
				System.out.println("Produced - "+i);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
