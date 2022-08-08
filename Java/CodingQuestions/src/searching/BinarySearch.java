package searching;

import java.util.Arrays;

/**
 * 1. Sort the array
 * 2. compare the element from the middle index. Based on result we can eliminate one half of the array. 
 * 3. Do this recursively.
 * */
public class BinarySearch {

	public static void main(String[] args) {

		int[] inputArr= new int[] {22,12,43,4,15};//4,12,15,22,43
		Arrays.sort(inputArr);
		System.out.println(binarySearchRecursive(inputArr, 43, 0, inputArr.length-1));
		System.out.println(binarySearchAPI(inputArr, 43));

		System.out.println(binarySearchRecursive(inputArr, 3, 0, inputArr.length-1));
		System.out.println(binarySearchAPI(inputArr, 3));
	}

	private static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {
		int middle = low  + ((high - low) / 2);
	    if (high < low) {
	        return -1;
	    }
	    if (key == sortedArray[middle]) {
	        return middle;
	    } else if (key < sortedArray[middle]) {
	        return binarySearchRecursive(
	          sortedArray, key, low, middle - 1);
	    } else {
	        return binarySearchRecursive(
	          sortedArray, key, middle + 1, high);
	    }
	}

	private static int binarySearchAPI(int[] inputArr, int key) {
		return Arrays.binarySearch(inputArr, key);//Collections.binarySearch()
	}

}
