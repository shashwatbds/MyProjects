package com.java.atomiclock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockCounter {

	private final ReentrantLock lock = new ReentrantLock();

	private int count =0;

	public int incrementAndGet() {
		System.out.println("Is locked "+lock.isLocked());

		System.out.println("Is headl by thread "+lock.isHeldByCurrentThread());
		boolean acquired = lock.tryLock();
		if(acquired) {
			try {
				Thread.sleep(2000);
				count+=1;
			} catch(InterruptedException e) {
				throw new IllegalStateException(e);
			} finally {
				lock.unlock();
			}
		}
		return count;
	}

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(2);
		final ReenterantLockCounter counter = new ReenterantLockCounter();
		es.submit(() -> {
			System.out.println("IncrementCount (First Thread) : " +
					counter.incrementAndGet() + "\n");
		});

		es.submit(() -> {
			System.out.println("IncrementCount (Second Thread) : " +
					counter.incrementAndGet() + "\n");
		});

		es.shutdown();
	}

}
