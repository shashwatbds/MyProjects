package com.java.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue, String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<=4; i++) {
			try {
				queue.put(i);
				System.out.println("Produced : "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
