package com.java.algorithms.sorting;

/**
 * 
 * */
public class SelectionSort {

	/**
	 * 
	 * */
	public int[] sort(int[] inputArr) {
		
		for(int i=0; i<inputArr.length-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<inputArr.length;j++) {
				if(inputArr[j]<inputArr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = inputArr[minIdx];
			inputArr[minIdx] = inputArr[i];
			inputArr[i] = temp;
		}
		
		return inputArr;
	}
	
	/**
	 * 
	 * */
	public static void main(String[] args) {

		int[] input = {64,25,12,22,11};
		SelectionSort ss = new SelectionSort();
		ss.printArray(input);

		ss.sort(input);
		ss.printArray(input);
		
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
