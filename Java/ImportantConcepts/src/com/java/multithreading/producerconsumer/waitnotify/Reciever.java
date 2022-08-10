package com.java.multithreading.producerconsumer.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Reciever implements Runnable {

	private Data load;
	
	public Reciever(Data load) {
		super();
		this.load = load;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(String recievedMessage = load.recieve();
			!"End".equalsIgnoreCase(recievedMessage); recievedMessage = load.recieve()) {
			System.out.println(recievedMessage);
			
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted"+e);
			}
		}
	}

}
