package com.test.java.MavenPractice;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.test.java.MavenPractice.Worker;

public class JUnitClass {

	@Test
	public void whenParallelProcessingThenMainThreadWillBlockUntillcompletion() throws InterruptedException {
		List<String> outputScrapper = Collections.synchronizedList(new ArrayList<String>());
		CountDownLatch cdl = new CountDownLatch(5);
		List<Thread> workers = Stream
				.generate(() -> new Thread(new Worker(outputScrapper, cdl)))
				.limit(5)
				.collect(Collectors.toList());
		
		workers.forEach(Thread::start);
		cdl.await();
		outputScrapper.add("Latch released");
		
		outputScrapper.forEach(System.out::println);
		assertTrue(outputScrapper.size()==6);
		assertTrue(outputScrapper.get(5)=="Latch released");
	}
	
}
