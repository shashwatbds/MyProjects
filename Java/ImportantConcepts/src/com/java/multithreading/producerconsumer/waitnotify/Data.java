package com.java.multithreading.producerconsumer.waitnotify;

public class Data {

	private String packet;

	//True if receiver should wait
	//False if sender should wait
	private boolean transfer = true;

	public synchronized String recieve() {
		while(transfer) {
			try {
				wait();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = true;

		String returnPacket = packet;
		notifyAll();
		return returnPacket;
	}

	public synchronized void send(String packet) {
		while(!transfer) {
			try {
				wait();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = false;
		this.packet = packet;
		notifyAll();
	}
}
