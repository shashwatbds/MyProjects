package com.java.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.java.racecondition.Counter;

public class SynchronizedExample {
	
	public static void main(String[] args) throws InterruptedException {
	
		ExecutorService es = Executors.newFixedThreadPool(10);
		Counter counter = new Counter();
		for(int i=0; i<1001; i++) {
			es.submit( () -> {
				counter.increment();	
			});
		}

		es.shutdown();
		es.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println(counter.getcount());
	}
}