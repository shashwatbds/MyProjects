package sorting;

public class SortArraysof012 {

	public static void main(String[] args) {

		int[] arr= {0,2,1,2,0};
		printArr(bubbleSort(arr, arr.length));
		int[] arr1= {10,5,3,1,24,32};
		printArr(bubbleSort(arr1, arr1.length));
	}

	private static void printArr(int[] sort) {
		for(int i: sort) {
			System.out.println(i);
		}
	}

	private static int[] bubbleSort(int[] arr, int length) {

		for(int i=0; i<length-1;i++) {
			for(int j=0; j<length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
