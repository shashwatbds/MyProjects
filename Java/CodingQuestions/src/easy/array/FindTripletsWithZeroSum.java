package easy.array;

import java.util.ArrayList;
import java.util.List;

public class FindTripletsWithZeroSum {


	public static void main(String[] args) {

		int[] arr = {0,-1,2,-3,1};
		int targetSum = 0;
		System.out.println(findTripplets(arr, arr.length, targetSum));
	}

	private static List<List<Integer>> findTripplets(int[] arr, int length, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<length-2; i++) {
			for(int j = i+2; j<length; j++) {
				if(arr[i]+arr[i+1]+arr[j] == targetSum) {
					List<Integer> res = new ArrayList<>();
					res.add(arr[i]);res.add(arr[i+1]);res.add(arr[j]);
					result.add(res);
				}
			}
		}

		return result;
	}



}
