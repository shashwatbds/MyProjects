package com.test.java.MavenPractice;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

	private List<String> outputScrapper;
	private CountDownLatch cdl;
	
	public Worker(List<String> outputScrapper, CountDownLatch cdl) {
		
		this.outputScrapper = outputScrapper;
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		
		System.out.println("Hello by "+Thread.currentThread().getName());
		outputScrapper.add("Counted Down");
		cdl.countDown();
	}

}
