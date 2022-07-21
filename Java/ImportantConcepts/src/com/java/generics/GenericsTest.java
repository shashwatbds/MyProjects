package com.java.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericsTest {

	public static void main(String[] args) {

		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		fromArrayToCollection(oa, co);// T inferred to be Object
		
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		fromArrayToCollection(sa, cs);// T inferred to be String
		fromArrayToCollection(sa, co);// T inferred to be Object
		
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();

		fromArrayToCollection(ia, cn);// T inferred to be Number
		fromArrayToCollection(fa, cn);// T inferred to be Number
		fromArrayToCollection(na, cn);// T inferred to be Number
		fromArrayToCollection(na, co);// T inferred to be Object
	}

	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
	    for (T o : a) {
	        c.add(o); // Correct
	    }
	}
}
