package sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr= {0,2,1,2,0};
		printArr(bubbleSort(arr, arr.length));
		int[] arr1= {10,5,3,1,24,32};
		printArr(bubbleSort(arr1, arr1.length));
		int arr2[] = {2,4,1,3,5};
		printArr(bubbleSort(arr2,arr2.length));
		int [] arr3 = {2,3,4,5,6};
		printArr(bubbleSort(arr3, arr3.length));

	}

	private static int[] bubbleSort(int[] arr, int length) {
		for(int i=0; i<length-1;i++) {
			for(int j=0; j<length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	private static void printArr(int[] sort) {
		for(int i: sort) {
			System.out.println(i);
		}
	}
}
