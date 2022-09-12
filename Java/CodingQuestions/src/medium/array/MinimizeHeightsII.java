package medium.array;

import java.util.Arrays;

public class MinimizeHeightsII {

	public static void main(String[] args) {

		int[] arr1 = new int[] {1,5,8,10};
		find(arr1, 2, arr1.length);
		
		int[] arr2 = new int[] {3,9,12,16,20};
		find(arr2, 3, arr2.length);
		
	}

	private static void find(int[] arr, int k, int n) {
		
		Arrays.sort(arr);
		
		int min =(arr[n-1]-k)-(arr[0]+k);// In this algorithm, worst case will be difference between first+k and last-k, so the only variable is middle elements +-k
		int tempmin, tempmax;
		
		tempmin = arr[0]+k;
		tempmax = arr[n-1]-k;
		
		for(int i=1; i<n; i++) {
		
			if(arr[i] - k <0) {
				continue;
			}
			
			tempmin = Math.min(arr[0] +k, arr[i]-k);
			tempmax = Math.max(arr[i-1]+k, arr[n-1]-k);
			min = Math.min(min, tempmax-tempmin);
		}
		
		System.out.println(min);
	}

}
