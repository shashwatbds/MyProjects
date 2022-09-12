package medium.array;

public class MinumumNumberOfJumps {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {1,3,5,8,9,2,6,7,6,8,9};//output 3
		find(arr1,arr1.length);
		
		int[] arr2 = new int[] {1,4,3,2,6,7};//output 2
		find(arr2,arr2.length);
	}

	private static void find(int[] arr, int length) {

		int next =0;
		next = arr[0];
		int count=1;
		while(next<(length-1)) {
			if(arr[next] ==0 ) {
				count = -1;
				break;
			}
			count++;
			next = next+arr[next];
		}
		System.out.println(count);
	}

}
