package com.java.multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Task task = new Task("Shashwat");
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Future<String> result = ex.submit(task);
		System.out.println(result.get());
	}

}
