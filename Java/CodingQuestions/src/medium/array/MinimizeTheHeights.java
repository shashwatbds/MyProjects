package medium.array;

import java.util.Arrays;

public class MinimizeTheHeights {

	public static void main(String[] args) {
		int arr[] = {1,5,8,10};
		Arrays.sort(arr);
		System.out.println(find(arr,2));

		int arr1[] = {3,9,12,16,20};
		Arrays.sort(arr1);
		System.out.println(find(arr1,3));
	}

	private static int find(int[] arr, int k) {
		int n = arr.length;
        Arrays.sort(arr);
		int mina, maxa, diff, tmax=0,tmin=0;
		mina = arr[0]+k;
		maxa = arr[n-1]-k;
		diff = arr[n-1] - arr[0];
		System.out.println("Initial tmax "+mina+ " maxa "+maxa+ " diff "+diff);
		for(int i=1; i<n; i++) {
			if(arr[i]<k) {
				continue;
			}
			tmax = Math.max(maxa, arr[i-1]+k);
			tmin = Math.min(mina, arr[i]-k);
			diff = Math.min(diff, tmax-tmin);
			System.out.println("tMax "+tmax+" value i-1 "+arr[i-1]+" tmin "+tmin +" value i "+arr[i]+" have difference "+diff + " at i="+i);

		}
		System.out.println("\nFinal tMax "+tmax+" tmin "+tmin+" have difference "+diff+"\n\n");
		return diff;
	}
}
