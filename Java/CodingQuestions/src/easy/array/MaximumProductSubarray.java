package easy.array;

public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] arr = {6,-3,-10,0,2};
		findMaxProduct(arr, arr.length);

		findMaxProduct1(arr, arr.length);

		int[] arr1 = {2,3,4,5,-1,0};
		findMaxProduct(arr1, arr1.length);
		findMaxProduct1(arr1, arr1.length);

	}

	private static void findMaxProduct(int[] arr, int length) {

		int max = 0;
		int start = 0; int end = 0;
		for(int i=0; i<length-1; i++) {
			int prod=arr[i];
			for(int j=i+1; j<length; j++) {
				prod*=arr[j];
				//				System.out.println(arr[i]+" and sum is "+sum +"\n");
				if(max < prod) {
					max = prod;
					start = i;
					end = j;
					//					System.out.println("Highest product from index "+i+" to "+j+" and product is "+max);
				}
			}
		}
		System.out.println("\n\nFinal Highest product from index "+start+" to "+end+" and product is "+max);
	}

	private static void findMaxProduct1(int[] arr, int length) {

		int max=arr[0],min=arr[0];
		int ans=arr[0];
		for(int i=1; i<length; i++) {
			if(arr[i] < 0) {
				int temp=max;
				max=min;
				min=temp;
			}
			max=Math.max(arr[i],max*arr[i]);
			min=Math.min(arr[i],min*arr[i]);
			ans=Math.max(ans,max);
		}
		System.out.println("\n\nFinal Highest product from index "+min+" to "+max+" and product is "+ans);
	}

}
