package com.java.practice.java.collections.list.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("JAVA"); list.add("J2EE"); list.add("JSP"); list.add("SERVLETS"); list.add("JDBC");
		System.out.println(list);   
		System.out.println(findElement(list, "JDBC"));
		printReverse(list);
	}

	private static int findElement(LinkedList<String> list, String element) {
		return list.indexOf(element);
	}

	private static void printReverse(LinkedList<String> list) {
		Iterator<String> itr = list.descendingIterator(); // Reverse Iterator.
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		Iterator<String> lItr = list.listIterator();
		while(lItr.hasNext()) {
			System.out.println(lItr.next());
		}
	}


}
