package com.java.algorithms.sorting;

public class InsertionSort {

	
	public int[] sort(int[] inputArr) {
	
		for(int i=0; i<=inputArr.length-1;i++) {
			int current = inputArr[i];
			int j = i-1;
			while(j>=0 && current<inputArr[j]) {
				inputArr[j+1] = inputArr[j];
				j = j-1;
			}
			inputArr[j+1] = current;
		}
		return inputArr;
	}
	
	public static void main(String[] args) {
		int[] inputArr = {12,2,6,5,9,4};
		InsertionSort is = new InsertionSort();
		is.printArray(inputArr);
		is.printArray(is.sort(inputArr));
	}
	
	/* 
	 * Prints the array 
	 * */
    private void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
