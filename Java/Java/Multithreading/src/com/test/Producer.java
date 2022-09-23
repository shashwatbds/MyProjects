package com.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> queue;
	private int maxSize;

	public Producer(BlockingQueue<Integer> queue, int maxSize) {
		super();
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {

		while(true) {
			//			synchronized(queue) {
//			while(queue.size()==maxSize) {
//				System.out.println("Queue full, waiting for elements to be consumed..");
//				try {
//					queue.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			Random random = new Random();
			int p = random.nextInt();
			System.out.println("Produced "+p);
			try {
				queue.put(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//				queue.notifyAll();
		}

		//		}
	}

}
