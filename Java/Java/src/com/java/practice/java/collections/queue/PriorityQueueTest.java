package com.java.practice.java.collections.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(21);pq.offer(111);pq.offer(41);pq.offer(221);pq.offer(111);pq.offer(121);pq.offer(214);
		
		System.out.println(pq);
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("\nAscending Order");
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		
		MyComparator mc = new MyComparator();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(7, mc);
		pq1.offer(21);pq1.offer(111);pq1.offer(41);pq1.offer(221);pq1.offer(121);pq1.offer(214);
		
		System.out.println("\nDescending Order");
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
	}

	public static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	}
}
