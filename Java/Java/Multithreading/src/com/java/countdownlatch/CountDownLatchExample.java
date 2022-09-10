package com.java.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {

		List<String> outputSrapper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(5);
		List<Thread> workers = Stream.generate(()->new Thread(new Worker(outputSrapper, countDownLatch)))
				.limit(5)
				.collect(Collectors.toList());
	
		workers.forEach(Thread::start);
		countDownLatch.await();
		outputSrapper.add("Latch released");
		
		outputSrapper.forEach(System.out::println);
	}

}
