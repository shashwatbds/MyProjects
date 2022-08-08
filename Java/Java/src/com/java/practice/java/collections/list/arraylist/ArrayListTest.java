package com.java.practice.java.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ArrayListTest {

	public static void main(String[] args) {
		//1. Compile time vs runtime safety
		System.out.println("\n\nFirst Exercise");

		Object[] arr = new String[2];
		//arr[0] = 3; // No compile time safety  - throws java.lang.ArrayStoreException at runtime.
		System.out.println("\n\nSecond Exercise");

		List<String> listStr = new ArrayList<String>();
		//list.add(0); - Compile time safety
		
		//2. Adding element at a particular position
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(1);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		System.out.println(listInt);
		listInt.add(1, 2);
		System.out.println(listInt);
		listInt.remove(3);
		System.out.println(listInt);
		
		int[] arrInt = new int[5];
		printArray(arrInt); // memory allocated to each element of array. 0 added by default.
		arrInt[0]=1;
		arrInt[2]=3;// Here by default 0 will be added to index 1.
		arrInt[3]=4;
		arrInt[4]=5;
		printArray(arrInt);
		arrInt[1]=2;
		printArray(arrInt);
		
		// default String arra elements
		String[] strArr = new String[5];
		printArray(strArr);// by default null is added.
		System.out.println("\n\nThird Exercise");

		//3. ArrayList Traversal
		ListIterator<Integer> itr = listInt.listIterator();
		while(itr.hasNext()) {
			System.out.println(	itr.next());
		}
		
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		
		System.out.println("\nIncrease Capacity of ArrayList");
		ArrayList<String> strList = new ArrayList<String>();//default capacity 10
		strList.ensureCapacity(20);//New Capacity 20
		strList.trimToSize();//Trim capacity to size. This will be 0 now. Once we add element it will regrow.
		
		System.out.println("\nSublist - ArrayList - Backed Collections");
		ArrayList<Integer> lstInt = new ArrayList<Integer>();
		lstInt.add(000);lstInt.add(111);
		lstInt.add(222);
		lstInt.add(333);
		lstInt.add(444);
		lstInt.add(555);
		lstInt.add(666);lstInt.add(777);lstInt.add(888);lstInt.add(999);
		System.out.println(lstInt);
		
		List<Integer> sublstInt = lstInt.subList(2, 5);
		System.out.println(sublstInt);
		
		sublstInt.set(2, 4444);
		System.out.println(lstInt);
		System.out.println(sublstInt);
		
		//Convert ArrayList to array and vice versa
		System.out.println("\nConvert ArrayList to array and vice versa");
		String[] strArray = new String[] {"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray));
		System.out.println(list);
		
		
		System.out.println("\nCollections - List addAll ");
		String[] strArray1 = new String[] {"ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		ArrayList<String> list1 = new ArrayList<String>();
		Collections.addAll(list1, strArray1);
		list1.addAll(2,Arrays.asList(strArray1));
		System.out.println(list1);
		
		System.out.println("\nCollections - List stream ");
		List<String> list11 = Arrays.stream(strArray1).collect(Collectors.toList()); //ArrayList type won't work here, List will work.
		System.out.println(list11);
		
	}

	private static void printArray(int[] arrInt) {
		for(int i : arrInt) {
			System.out.println(i);
		}
	}

	private static void printArray(String[] strArr) {
		for(String i : strArr) {
			System.out.println(i);
		}
	}
}
