package com.java.producerconsumer.waitnotify;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

	private Queue<Integer> queue;
	private int maxSize;
	
	
	public Producer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}


	@Override
	public void run() {
		while(true) {
			synchronized(queue) {
				while(queue.size()==maxSize) {
					System.out.println("Queue full... waiting..");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int i = random.nextInt();
				System.out.println("Producing : "+i);
				queue.add(i);
				queue.notifyAll();
			}
		}
		
	}
}
