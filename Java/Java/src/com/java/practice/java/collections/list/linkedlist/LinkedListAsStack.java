package com.java.practice.java.collections.list.linkedlist;

import java.util.LinkedList;

public class LinkedListAsStack {

	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(1);stack.push(2);stack.push(3);stack.push(4);// Adds to the beginning of the list. It is same as AddFirst
		System.out.println(stack);
		
		System.out.println(stack.pop());// Removes element from index 0. It is same as remove or poll
		System.out.println(stack.poll());// Removes element from index 0. It is same as remove or poll
		System.out.println(stack.remove());// Removes element from index 0. It is same as remove or poll
		
		
	}

}
