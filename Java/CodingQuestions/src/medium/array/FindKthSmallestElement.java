package medium.array;

import java.util.Arrays;

public class FindKthSmallestElement {

	public static void main(String[] args) {
		int[] arr = {7,10,4,3,20,15};
		Arrays.sort(arr);
		find(arr,3);
		
		int[] arr1 = {7,10,4,20,15};
		Arrays.sort(arr1);
		find(arr1,4);
	}

	private static void find(int[] arr, int i) {
		
		System.out.println(arr[i-1]);
	}

}
