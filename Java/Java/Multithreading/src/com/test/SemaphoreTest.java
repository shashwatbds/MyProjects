package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	private int count;
	private Semaphore sem;

	public SemaphoreTest(int count, Semaphore sem) {
		super();
		this.count = count;
		this.sem = sem;
	}

	public void getAndIncrement() throws InterruptedException {
		sem.acquire();
		count++;
		sem.release();
	}
	
	public void get() {
		System.out.println(count);
	}

	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(1);
		ExecutorService es = Executors.newFixedThreadPool(10);
		SemaphoreTest example = new SemaphoreTest(0, sem);
		for(int i=0; i<1000; i++) {
			es.submit(()-> {
				try {
					example.getAndIncrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			});
		}
		
		es.shutdown();es.awaitTermination(1000, TimeUnit.SECONDS);
		example.get();
		
	}

}
