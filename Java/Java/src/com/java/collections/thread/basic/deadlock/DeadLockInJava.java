package com.java.practice.java.collections.thread.basic.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadLockInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shared s1 = new Shared();
		Shared s2 = new Shared();

		Thread t1 = new Thread() {

			@Override
			public void run() {
				s1.methodOne(s2);
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				s2.methodOne(s1);
			}
		};
		
		t1.start();t2.start();
		
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		long ids[] = bean.findMonitorDeadlockedThreads();
		System.out.println(ids);
	}

}
