package medium;

public class MergeSort {
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,10};

		int i = mergeSort(arr);
	}

	private static int mergeSort(int[] arr) {

		int count = 0;
		int size = arr.length;
		if(size <2) {
			return 0;
		}

		int midIndex = 0;
		if(size%2 ==0 ) {
			midIndex = size/2;
		} else {
			midIndex= size/2+1;
		}
		

		return count;
	}
	
	static long mergeSort(int[] a, int[] temp, int left, int right){
        long count = 0;
        if(right <= left) return 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(a, temp, left, mid);
        count += mergeSort(a, temp, mid + 1, right);
       // count += mergeSort(a, temp, left, mid, right);
        return count;
    }
}
