package com.java.practice.java.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BasicSortingTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		//Adding elements to list
		list.add("Virat");
		list.add("rohit");
		list.add("Shikar");
		list.add("ashwin");
		list.add("ravindra");
		list.add("Bhargav");
		System.out.println("\nReverse ArrayList");
		System.out.println(list);
		Collections.reverse(list);// Return type of the method is void and hence ordering is done inline. 
		System.out.println(list);

		//Creating an ArrayList of strings

		System.out.println("ArrayList Before Sorting :");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);// Sorting Camel case first and then small case. Considering two lists out of one lists.
		
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(list);

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.compareTo(str1);
			}
		});
		System.out.println(list);

	}

}
