package com.java.algorithms.sorting;

public class BubbleSort {

	
	public static int[] bubbleSort(int[] arr) {
		
		
		int size = arr.length;
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-i-1;j++) {
				int temp = 0;
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				printArray(arr);
			}
		}
		
		return arr;
		
	}
	
	/* Prints the array */
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10,4,5,2,9,6,13};
		printArray(arr);

		bubbleSort(arr);
		
	}

}
