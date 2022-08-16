package easy.array;

import java.util.Arrays;

public class FindTrippletsWithGivenSum {

	public static void main(String[] args) {

		int[] arr = {1,4,45,6,10,8}; 
		System.out.println(findTripplets(arr, 13));
		System.out.println(findTripplets(arr, 14));
		System.out.println(findTripplets(arr, 46));
		System.out.println(findTripplets(arr, 20));
		System.out.println(findTripplets(arr, 50));

	}

	private static boolean findTripplets(int[] arr, int target) {
		Arrays.sort(arr);
		for(int i =0; i<arr.length; i++) {
			int low = i+1;
			int high = arr.length-1;
			while(low<high) {
				int sum = arr[i] + arr[low] + arr[high];
				if(sum<target) {
					low+=1;
				} else if(sum>target) {
					high-=1;
				} else {
					return true;
				}
			}
			
		}
		return false;
	}

}
