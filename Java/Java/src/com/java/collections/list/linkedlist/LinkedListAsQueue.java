package com.java.practice.java.collections.list.linkedlist;

import java.util.LinkedList;

public class LinkedListAsQueue {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);queue.offer(2);queue.add(3);queue.add(4);// Adds to the end of the list.
		System.out.println(queue);
		
		//FIFO
		System.out.println(queue.poll());//Poll removes first entered element or the element at index 0.
	}

}
