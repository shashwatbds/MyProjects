package com.java.multithreading.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterWithoutSynchronization implements Runnable {

	private static int counter = 0;
	private static final int limit = 1000;
    private static final int threadPoolSize = 5;

	@Override
	public void run() {
		while(counter < limit) {
			increaseCounter();
		}
	}

	private void increaseCounter() {
		System.out.println(Thread.currentThread().getName() + " : " + counter);
		counter++;
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new CounterWithoutSynchronization());
        }
        executorService.shutdown();	
	}
}
