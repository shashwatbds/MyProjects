package com.java;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonLazyAndThreadSafe {

	private static final SingletonLazyAndThreadSafe INSTANCE1 = new SingletonLazyAndThreadSafe();

	private SingletonLazyAndThreadSafe () {
	}

	public static SingletonLazyAndThreadSafe getInstance() {
		//Thread.sleep(1000);
		return Inner.INSTANCE;
	}
	
	public int division(int i, int j) throws InterruptedException{
		if(Objects.nonNull(j)) {
			return i/j;
		} else {
			throw new NullPointerException();
		}
		
	}

	static class Inner {
		private static final SingletonLazyAndThreadSafe INSTANCE = new SingletonLazyAndThreadSafe();//Bill plough
	}

	public static void main(String[] args) {
		
//		SingletonLazyAndThreadSafe.getInstance().division(1, 0);
		
//		ExecutorService es = Executors.newFixedThreadPool(5);
//		for(int i=0; i<4; i++) {
//			es.submit(()-> {
//				try {
//					System.out.println(SingletonLazyAndThreadSafe.getInstance().hashCode());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			});
//		}
//		es.shutdown();
	}
}
