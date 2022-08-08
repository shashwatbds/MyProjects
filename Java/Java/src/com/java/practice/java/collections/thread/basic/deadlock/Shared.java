package com.java.practice.java.collections.thread.basic.deadlock;

public class Shared {
	synchronized void methodOne(Shared s)
	{
		Thread t = Thread.currentThread();

		System.out.println(t.getName()+"is executing methodOne...");

		System.out.println(t.getName()+"is calling methodTwo...");

		s.methodTwo(this);

		System.out.println(t.getName()+"is finished executing methodOne...");
	}

	synchronized void methodTwo(Shared s)
	{
		Thread t = Thread.currentThread();

		System.out.println(t.getName()+"is executing methodTwo...");

		System.out.println(t.getName()+"is calling methodOne...");

		s.methodOne(this);

		System.out.println(t.getName()+"is finished executing methodTwo...");
	}
}
