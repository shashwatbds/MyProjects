package medium.array;

public class FindMajorityElement {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		find(arr,arr.length);
		
		int[] arr2 = new int[] {3,3,1,2,3};
		find(arr2,arr2.length);
	}

	private static void find(int[] arr, int length) {

		int maxCount = 0;
		int maxNum = 0;
		for(int i=0; i<(length/2+2); i++) {
			int j=i+1;
			while(j<length) {
				if(arr[i]==arr[j]) {
					maxCount++;
					maxNum=arr[i];
				}
				j++;
			}
		}
		System.out.println(maxNum+ " is a majority element in the given input array, exists "+maxCount+" times");
	}
}
