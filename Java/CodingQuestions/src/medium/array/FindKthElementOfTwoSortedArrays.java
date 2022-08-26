package medium.array;

import java.util.Arrays;

public class FindKthElementOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {2,3,6,7,9};
		Arrays.sort(arr1);
		int[] arr2 = {1,4,8,10};
		Arrays.sort(arr2);
		find(arr1,arr2, 5);

		
		int[] arr3 = {100,112,256,349,770};
		Arrays.sort(arr3);
		int[] arr4 = {72,86,113,119,265,445,892};
		Arrays.sort(arr4);
		find(arr3,arr4, 7);
	}

	private static void find(int[] arr1, int[] arr2, int k) {

		int len1 = arr1.length;
		int len2 = arr2.length;
		int limit = (len1<len2) ? len2 : len1;
		int count = 0;
		boolean found = false;
		for(int i=0; i<limit; i++) {
			int x=0,y=0;
			if(found)
				break;
			while(x!=len1 || y != len2) {
				int a1 = arr1[x];
				int a2 = arr2[y];
				int temp = a1;
				if(a1<a2) {
					count++;
					x++;
				} else if(a2<a1) {
					count++;
					y++;
				} else {
					count+=2;
					x++;y++;
				}
				if(count==k) {
					System.out.println(temp);
					found = true;
					break;
				}
			}
		}
	}

}
