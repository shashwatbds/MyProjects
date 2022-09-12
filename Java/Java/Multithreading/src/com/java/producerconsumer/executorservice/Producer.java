package com.java.producerconsumer.executorservice;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Integer> queue;
	
	
	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		for(int i =0; i<11; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Produced "+i+ " by "+Thread.currentThread().getName());
		}
		
	}

}
