package sorting;

public class MergeSort {
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,10};

//		System.out.println(mergeSort(arr));
	}

	static long mergeSort(int[] a, int[] temp, int left, int right){
        long count = 0;
        if(right <= left) return 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(a, temp, left, mid);
        count += mergeSort(a, temp, mid + 1, right);
//        count += mergeSort(a, temp, left, mid, right);
        return count;
    }
}
