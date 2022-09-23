package com.test;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			//			synchronized(queue) {
//			while(queue.isEmpty()) {
//				System.out.println("Queue is empty, waiting for something to be produced..");
//				try {
//					queue.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			int i;
			try {
				i = queue.take();
				System.out.println("Consumed "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//				queue.notifyAll();
			//			}
		}
	}
}
