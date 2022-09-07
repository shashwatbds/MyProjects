package com.java.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<Integer> queue;
	private int taken = -1;

	public Consumer(BlockingQueue<Integer> queue, String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {

		while(taken!=4){
			try {
				taken = queue.take();
				System.out.println("Consumer :"+taken);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
