package com.java.practive.algorithms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find the length of the longest sub-sequence
 *  such that elements in the subsequence are consecutive integers, 
 *  the consecutive numbers can be in any order
 *  Examples:
 *  Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
	Output: 4
	Explanation: 
	The subsequence 1, 3, 4, 2 is the longest 
	subsequence of consecutive elements

	Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
	Output: 5
	Explanation: 
	The subsequence 36, 35, 33, 34, 32 is the longest 
	subsequence of consecutive elements.
 * */
public class LongestSequenceOfConsecutiveNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 9, 3, 10, 4, 20, 2};
		int[] arr2 = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		System.out.println(
	            "Length of the Longest consecutive subsequence is "
	            + findLongestSequenceLengthInArray(arr1));
	    System.out.println(
	            "Length of the Longest consecutive subsequence is "
	            + findLongestSequenceLengthInArray(arr2));
	}

	public static int findLongestSequenceLengthInArray(int[] arr){
		int ans = 0;
		// Hash all the array elements
		Set<Integer> numbers = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
//			System.out.println(i);
			numbers.add(arr[i]);
		}
		
//		numbers.forEach(System.out::println);
		// check each possible sequence from the start
        // then update optimal length
		for(int i=0; i<arr.length; i++) {
			// if current element is the starting
            // element of a sequence
			System.out.println(arr[i]-1);
			if(!numbers.contains(arr[i]-1)) {
				int j = arr[i];
				while(numbers.contains(j)) {
					j++;
				}
				
				if(ans<j-arr[i]) {
					ans = j - arr[i];
				}
			}
		}
		
		return ans;
							
	}
}
