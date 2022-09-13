package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

	public static void main(String[] args) {
		
		List<List<String>> lists = new ArrayList<>();
		List<String> lst1 = new ArrayList<> ();//[["bat"],["nat","tan"],["ate","eat","tea"]]
		lst1.add("bat");
		List<String> lst2 = new ArrayList<> ();//[["bat"],["nat","tan"],["ate","eat","tea"]]
		lst2.add("nat");lst2.add("tan");
		lists.add(lst2);lists.add(lst1);
		lists.stream()
		.flatMap(l->l.stream())
		.peek(System.out::println)
		.collect(Collectors.toList());
		
	}

}
