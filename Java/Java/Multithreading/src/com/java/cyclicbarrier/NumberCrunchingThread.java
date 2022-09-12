package com.java.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class NumberCrunchingThread implements Runnable{

	private CyclicBarrier cyclicBarrier;
	private List<List<Integer>> partialResults;
	private Random random = new Random();
	private int NUM_PARTIAL_RESULTS;

	public NumberCrunchingThread(CyclicBarrier cyclicBarrier, List<List<Integer>> partialResults,
			int NUM_PARTIAL_RESULTS) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.partialResults = partialResults;
		this.NUM_PARTIAL_RESULTS = NUM_PARTIAL_RESULTS;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		List<Integer> partialResult = new ArrayList<>();

		for(int i=0; i<NUM_PARTIAL_RESULTS; i++) {
			Integer num = random.nextInt();
			System.out.println(threadName+" crunching some numbers! Final Result - "+num);
			partialResult.add(num);
		}

		partialResults.add(partialResult);
		try {
			System.out.println(threadName 
					+ " waiting for others to reach barrier.");
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}
	}

}
