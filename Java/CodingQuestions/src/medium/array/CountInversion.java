package medium.array;

/**
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. 
 * If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * */
public class CountInversion {

	public static void main(String[] args) {
		int arr[] = {2,4,1,3,5};
		find(arr);

		int [] arr1 = {2,3,4,5,6};
		find(arr1);
	}

	private static void find(int[] arr) {
		int swapCount = 0;
		for(int i =0; i<arr.length-1; i++) {
			int j=i+1;
			while(j<arr.length) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					swapCount +=1;
				}
				j++;
			}
		}
		System.out.println(swapCount);
	}
}
