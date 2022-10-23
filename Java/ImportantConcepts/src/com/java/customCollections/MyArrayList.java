package com.java.customCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyArrayList<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private static final Object[] EMPTY_LIST = {};

	private int modCount;

	private int size;

	private Object[] listContent;

	public MyArrayList() {
		listContent = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public MyArrayList(Object[] inputArray) {
		if(Objects.nonNull(inputArray)) {
			listContent = Arrays.copyOf(inputArray, inputArray.length);
		}
	}

	public MyArrayList(List<? extends T> inputList) {
		
		if( (size=inputList.size()) != 0) {
			Object[] a = inputList.toArray();
			if(inputList.getClass() == ArrayList.class) {
				listContent = a;
			} else {
				Arrays.copyOf(a, inputList.size(), Object[].class);
			}
		} else {
			listContent = EMPTY_LIST;
		}
	}


	public void add(T t) {
		if(size == listContent.length) {
			ensureCapacity();
		}
		listContent[size++] = t;
	}

	public T get(int index) {
	
		if(index<0 || index > getSize()) {
			throw new ArrayIndexOutOfBoundsException("Negative Indexes not allowed");
		}
		return (T) listContent[index];
	}
	
	private void ensureCapacity() {
		Object[] copy = new Object[this.size*2];
		copy = Arrays.copyOf(listContent, this.size*2);
		listContent = copy;
	}
	
	private Object remove(int index) {
		if(index<0 || index > getSize()) {
			throw new ArrayIndexOutOfBoundsException("Negative Indexes not allowed");
		}
		
		Object removedElement = listContent[index];
		
		for(int i=index; i<this.getSize()-1;i++) {
			listContent[i] = listContent[i+1];
		}
		return removedElement;
		
	}

	public int getSize() {
		return listContent.length;
	}

	public static void main(String[] args) {

		Integer[] ints = new Integer[5];
		ints[0] = 0;ints[1] = 1;ints[2] = 2;ints[3] = 3;ints[4] = 4;
		MyArrayList<Integer> intList = new MyArrayList<>(ints);
		System.out.println(intList.get(3));
		intList.add(6);
		System.out.println(intList.get(intList.getSize()-1));
		intList.remove(3);
		System.out.println(intList.get(3));

		
		System.out.println("\n");
		
		String[] strings = new String[5];
		strings[0] = "0";strings[1] = "1";strings[2] = "2";strings[3] = "3";strings[4] = "4";
		MyArrayList<String> stringList = new MyArrayList<>(strings);
		System.out.println(stringList.get(3));
		stringList.add("6");
		System.out.println(stringList.get(stringList.getSize()-1));
		stringList.remove(3);
		System.out.println(stringList.get(3));
		
		

		
	}

}
