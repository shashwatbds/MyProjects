package easy.array;

import java.util.Objects;

public class CountPairsWithGivenSum {

	public static void main(String[] args) {

		int[] arr = {1,5,7,1};
		System.out.println(getPairCount(arr, 4, 6));

		int[] arr2 = {1,1,1,1};
		System.out.println(getPairCount(arr2, 4, 2));
		
		int[] arr3 = {1,1,-1,1};
		System.out.println(getPairCount(arr3, 4, 0));
	}

	private static int getPairCount(int[] arr, int n, int k){
		if(Objects.nonNull(arr) && arr.length == 0) {
			return 0;
		}
		int count = 0;
		for(int i=0; i<n; i++) {
			int j = i+1;
			while(j != n) {
				if(arr[i] + arr[j] == k) {
					count++;
				}
				j++;
			}
		}
		return count;
	}

}
