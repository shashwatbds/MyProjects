package com.java.multithreading.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithAtomicInteger implements Runnable {

	private AtomicInteger counter = new AtomicInteger(0);
	private static final int limit = 100;
    private static final int threadPoolSize = 5;
	public Object object = new Object();

	@Override
	public void run() {
		while(counter.get() < limit) { //  If this line is not in
			increaseCounter();
		}
	}

	private void increaseCounter() {
		System.out.println(Thread.currentThread().getName() + " : " + counter);
		counter.getAndIncrement();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new CounterWithAtomicInteger());
        }
        executorService.shutdown();
	}

}
