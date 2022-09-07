package com.java.atomiclock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	final ReadWriteLock lock = new ReentrantReadWriteLock();
	private int count = 0;
	
	public int getAndIncrement() {
	
		lock.writeLock().lock();
		try {
			count = count+=1;
			return count;
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public int get() {
		
		lock.readLock().lock();
		try {
			return count;
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public static void main(String[] args) {

	}

}
