package com.java.cyclicbarrier;

import java.util.List;
import java.util.Random;

public class NumberAggregatorThread implements Runnable {

	private List<List<Integer>> partialResults;
	private Random random = new Random();
	private int NUM_PARTIAL_RESULTS, NUM_WORKERS;

	public NumberAggregatorThread(List<List<Integer>> partialResults,
			int NUM_WORKERS, int NUM_PARTIAL_RESULTS) {
		super();
		this.partialResults = partialResults;
		this.NUM_WORKERS = NUM_WORKERS;
		this.NUM_PARTIAL_RESULTS = NUM_PARTIAL_RESULTS;
	}

	@Override
	public void run() {

		String thisThreadName = Thread.currentThread().getName();

		System.out.println(
				thisThreadName + ": Computing sum of " + NUM_WORKERS 
				+ " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
		int sum = 0;

		for(List<Integer> partialResult: partialResults) {
			System.out.println("Adding ");
			for (Integer result : partialResult) {
				System.out.print(result+" ");
				sum += result;
			}
			System.out.println();
		}
		System.out.println(thisThreadName + ": Final result = " + sum);

	}

}
