package com.java.cyclicbarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	private CyclicBarrier cyclicBarrier;
	private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
	private int NUM_PARTIAL_RESULTS;
	private int NUM_WORKERS;

	public void runSimulation(int numWorkers, int numberOfPartialResults) {
		NUM_PARTIAL_RESULTS = numberOfPartialResults;
		NUM_WORKERS = numWorkers;

		cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new NumberAggregatorThread(partialResults, NUM_WORKERS, NUM_PARTIAL_RESULTS));

		System.out.println("Spawning " + NUM_WORKERS
				+ " worker threads to compute "
				+ NUM_PARTIAL_RESULTS + " partial results each");

		for (int i = 0; i < NUM_WORKERS; i++) {
			Thread worker = new Thread(new NumberCrunchingThread(cyclicBarrier, partialResults, NUM_PARTIAL_RESULTS));
			worker.setName("Thread " + i);
			worker.start();
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrierDemo demo = new CyclicBarrierDemo();
		demo.runSimulation(5, 3);
	}
}
