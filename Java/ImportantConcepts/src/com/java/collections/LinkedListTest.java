package com.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll = new LinkedList<Integer>();
		//Adding elements
		ll.add(1);
		ll.add(3);
		ll.add(1,2);
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(4);
		al.add(5);
		ll.addAll(al);
		
		ll.addFirst(0);
		ll.addLast(6);
		
//		//fetch elements
//		System.out.println(ll.contains(2));
//		
//		//Iterate a list
//		
//		Iterator<Integer> itr = ll.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		
//		Iterator<Integer> ditr = ll.descendingIterator();
//		while(ditr.hasNext()) {
//			System.out.println(ditr.next());
//		}
		
//		System.out.println(ll.element());
//		System.out.println(ll.getFirst());
//
//		System.out.println(ll.getLast());
//		System.out.println(ll.indexOf(4));
//		
//		
//		System.out.println(ll.element());
		ll.offer(7);
		ll.offerFirst(-1);
		ll.offerLast(8);
		
		System.out.println(ll.peek());
		
		//remove elements
		
		//deque functions
		
		printList(ll);
	}
	
	public static void printList(List<Integer> list) {
		list.forEach(System.out::println);
	}

}
