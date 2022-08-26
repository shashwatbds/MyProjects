package easy.array;

public class FindDuplicatesInUnsortedArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,2,3,2,1,4,5};
		for(int i=0; i<arr.length; i++) {
			int j=i+1;
			while(j<arr.length) {
				if(arr[i] == arr[j]) {
					System.out.println(arr[i]+" at index "+i+" is also repeated at index "+j);
				}
				j++;
			}
		}
	}

}
