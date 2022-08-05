package com.java.practice.java.collections.map.hashmap;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//Adding key-value pairs
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);
		System.out.println(map);
		map.putIfAbsent("ONE", 2);
		map.putIfAbsent("FIVE", 5);
		System.out.println(map);
		
		System.out.println(map.containsKey("FOUR")+ " "+ map.containsValue(5));
		
		map.remove("FIVE",3);
		System.out.println(map);
		map.remove("FIVE", 5);
		System.out.println(map);
	}
}
