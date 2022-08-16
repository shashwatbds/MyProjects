package easy.array;

import java.util.Arrays;

public class RemoveDuplicateElementsFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2,2,2,2,2};
		Arrays.sort(arr);
		System.out.println(removeDuplicates(arr));
		int[] arr1 = {1,2,2,2,2};
		Arrays.sort(arr1);
		System.out.println(removeDuplicates(arr1));
		int[] arr2 = {1,2,3,4,5,6,3};
		Arrays.sort(arr2);
		System.out.println(removeDuplicates(arr2));
	}

	private static int removeDuplicates(int[] inputArray) {
		int count=0;
		for(int i=0; i<inputArray.length-1; i++) {
			if(inputArray[i] == inputArray[i+1]) {
				inputArray[i] = -1;
				count+=1;
			}
		}
		return inputArray.length-count;
	}
	
	private static void printArr(int[] arr) {
		for(int i : arr) {
			System.out.println(i);
		}
	}

	
}
