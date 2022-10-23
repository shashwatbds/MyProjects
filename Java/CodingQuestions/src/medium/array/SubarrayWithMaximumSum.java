package medium.array;

public class SubarrayWithMaximumSum {

	public static void main(String[] args) {

		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(find(arr));

		int[] arr1 = {1};
		System.out.println(find(arr1));

		int[] arr2 = {5,4,-1,7,8};
		System.out.println(find(arr2));

	}

	private static int find(int[] arr) {

		if(arr.length>0) {
			
			int maxSum = arr[0];
			for(int i=0; i<arr.length; i++) {
				int j=i+1;
				int sum=arr[i];
				while(j<arr.length) {
					sum += arr[j];
					if(sum>maxSum) {
						maxSum = sum;
					}
					j++;
				}
			}

			return maxSum;
		} else 
			return 0;
	}

}
