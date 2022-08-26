package medium.array;

import java.util.Arrays;

public class FindTrippletWithgivenSum {

	public static void main(String[] args) {
		
		int[] arr = {1,4,35,6,10,8};
		Arrays.sort(arr);
		find(arr,13);
		
		int[] arr1 = {1,2,4,3,6};
		Arrays.sort(arr1);
		find(arr1,10);
		
		int[] arr3 = {1,4,35,6,10,8,3};
		Arrays.sort(arr3);
		find(arr3,13);
	}

	private static void find(int[] arr, int sum) {

		int len = arr.length;
		int count = 0;
		for(int i=0; i<len; i++) {
			int a = i+1; 
			int b = len-1;
			while(a<b) {
				int tempsum = arr[i]+arr[a]+arr[b];
				if(tempsum == sum) {
					count++;
					break;
				} else if(tempsum<sum) {
					a+=1;
				} else {
					b-=1;
				}
			}
		}
		
		System.out.println(count);
	}

}
