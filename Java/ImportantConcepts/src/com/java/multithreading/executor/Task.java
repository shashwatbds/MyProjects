package com.java.multithreading.executor;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	private String message;
	
	public Task(String message) {
		super();
		this.message = message;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hi, "+this.message+"!";
	}

	
}
