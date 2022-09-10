package com.java.synchronizedexample;

public class Counter {

	int count = 0;
	
	public synchronized void increment() {
//		synchronized (this) { //synchronized keyword in method or this block, either will work
			count+=1;
//		}
	}
	
	public int getcount() {
		return count;
	}
}
