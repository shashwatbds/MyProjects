package com.java.oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {

	private final int property1;// properties must be private final
	private final int property2;
	
	private final List<Integer> sampleList;
	
	public ImmutableClass(int property1, int property2, List<Integer> sampleList) {
		super();
		this.property1 = property1;
		this.property2 = property2;
		this.sampleList = new ArrayList<>(sampleList);//New in Constructor - Deep copy - Collections.unmodifiableList
	}

	public int getProperty1() {
		return property1;
	}

	public int getProperty2() {
		return property2;
	}

	public List<Integer> getSampleList() {
		return new ArrayList<>(sampleList);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		ImmutableClass obj = new ImmutableClass(1,2,list);

		list.add(3);
		System.out.println(obj.getSampleList().size());
		obj.getSampleList().add(4);
		System.out.println(obj.getSampleList().size());

		
	}

}
