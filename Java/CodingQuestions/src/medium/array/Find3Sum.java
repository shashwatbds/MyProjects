package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Find3Sum {

	public static void main(String[] args) {

		Integer[] arr = {-1,0,1,2,-1,-4};
		find(new ArrayList<Integer>(Arrays.asList(arr))).stream().forEach(System.out::println);
		Integer[] arr1 = {0,1,1};
		find(new ArrayList<Integer>(Arrays.asList(arr1))).stream().forEach(System.out::println);
		Integer[] arr2 = {0,0,0};
		find(new ArrayList<Integer>(Arrays.asList(arr2))).stream().forEach(System.out::println);
	}

	private static List<List<Integer>> find(List<Integer> list) {

		List<List<Integer>> triplets = new ArrayList<>();
		for(int i=0; i<list.size()-2; i++) {
			int j=i+1;
			while(j<list.size()-1) {
				int k = j+1;
				while(k<list.size()) {
					if(list.get(i) + list.get(j) + list.get(k) == 0) {
						List<Integer> triplet = new ArrayList<>();
						triplet.add(list.get(i));triplet.add(list.get(j));triplet.add(list.get(k));
						Collections.sort(triplet);
						if(checkDuplicate(triplets, triplet)) {
							triplets.add(triplet);
						}
					}
					k++;
				}
				j++;
			}
		}
		return triplets;
	}

	private static boolean checkDuplicate(List<List<Integer>> triplets, List<Integer> triplet) {
		return !triplets.contains(triplet);
	}

}
