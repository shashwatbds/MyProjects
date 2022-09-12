package com.java.producerconsumer.executorservice;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Integer> queue;
	
	
	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		int j=11;
		while(j>0) {
			try {
				int i = queue.take();
				System.out.println("Consumed "+i+" by "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j--;
		}
		
	}

}
