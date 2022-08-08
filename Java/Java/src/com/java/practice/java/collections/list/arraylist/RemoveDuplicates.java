package com.java.practice.java.collections.list.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//Sorting without maintaining insertion order
		List<String> list = new ArrayList<String>();
		//Adding elements to list
		list.add("Virat");
		list.add("rohit");
		list.add("Shikar");
		list.add("ashwin");
		list.add("ravindra");
		list.add("Bhargav");
		list.add("ravindra");

		System.out.println(list);
		Set<String> set = new HashSet<>();
		set.addAll(list);
		List<String> list1 = set.stream().collect(Collectors.toList());
		System.out.println(list1);
		
		//Maintaining insertion order while removing duplicates.
		Set<String> lset = new LinkedHashSet<>();
		lset.addAll(list);
		List<String> list2 = lset.stream().collect(Collectors.toList());
		System.out.println(list2);
	}

}
