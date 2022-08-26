package medium.array;

public class FiindMinimumNumberOfJumps {

	public static void main(String[] args) {
		int[] arr = {1,3,5,8,9,2,6,7,8,9};
		System.out.println(find(arr, arr.length));	
		
		int[] arr2 = {1,4,3,2,6,7};
		System.out.println(find(arr2, arr2.length));	
	}

	private static int find(int[] arr, int len) {
		int jumpCount = 0;
		int index = 0;
		while(index<(len-1)) {
			if(arr[index] ==0 ) {
				jumpCount = -1;
				break;
			}
			index+=arr[index];
			jumpCount+=1;
		}
		
		return jumpCount;
		
	}
	
}
