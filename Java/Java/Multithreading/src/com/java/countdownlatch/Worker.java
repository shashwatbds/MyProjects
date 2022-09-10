package com.java.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	
	private List<String> outputScrapper;
	private CountDownLatch countDownLatch;
	
	public Worker(List<String> outputScrapper, CountDownLatch countDownLatch) {
		super();
		this.outputScrapper = outputScrapper;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		
		System.out.println("Doing Work...");
		outputScrapper.add("CountedDown..");
		countDownLatch.countDown();
	}
}
