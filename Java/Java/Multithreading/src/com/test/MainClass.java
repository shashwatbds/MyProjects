package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<1000; i++) {
			es.submit(()->c.increment());
		}
		es.shutdown();
		es.awaitTermination(1000, TimeUnit.SECONDS);
		c.getCount();
	}

}
