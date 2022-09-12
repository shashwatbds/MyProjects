package com.java.semaphore;

import java.util.concurrent.Semaphore;

public class Counter {

	private int count = 0;
	private Semaphore semaphore = new Semaphore(1);

	public void increment() throws InterruptedException {
		semaphore.acquire();
		count+=1;
		semaphore.release();
	}

	public int getcount() {
		return count;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
}
