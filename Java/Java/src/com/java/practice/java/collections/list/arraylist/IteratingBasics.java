package com.java.practice.java.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratingBasics {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		//Traversing list elements using Iterator
		System.out.println(list);
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())      {
			String str = itr.next();
			if(str.equalsIgnoreCase("two"))
				itr.remove();
		}
		System.out.println(list);

		list.add("TWO");
		System.out.println(list);
		ListIterator<String> litr = list.listIterator();
		while (litr.hasNext())      {
			String str = litr.next();
			System.out.println(str);
		}
		
		while(litr.hasPrevious()) {
			System.out.println(litr.previousIndex());
			String str = litr.previous();
			if(str.equalsIgnoreCase("two"))
				litr.set("Two");
		}
		System.out.println(list);
		
		ListIterator<String> litr1 = list.listIterator(1);//iterate from a particular index.
		while (litr1.hasNext()) {
			System.out.println(litr1.next());
			
		}
	}

}
