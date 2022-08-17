package com.java.oops;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

	private int property1;
	private int property2;
	
	private List<Integer> sampleList;
	
	public ImmutableClass(int property1, int property2) {
		super();
		this.property1 = property1;
		this.property2 = property2;
		this.sampleList = new ArrayList<Integer>();
	}

	public static void main(String[] args) {

	}

	public int getProperty1() {
		return property1;
	}

	public int getProperty2() {
		return property2;
	}

	public List<Integer> getSampleList() {
		return sampleList;
	}
	
	

}
