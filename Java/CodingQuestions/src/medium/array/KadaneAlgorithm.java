package medium.array;

public class KadaneAlgorithm {

	public static void main(String[] args) {

		int[] arr1 = new int[]{1,2,3,-2,5};
		find(arr1, arr1.length);
		
		int[] arr2 = new int[]{-1,-2,-3,-4};
		find(arr2, arr2.length);
	}

	private static void find(int[] arr, int length) {
		
		int max = arr[0];
		int startIdx=0,endIdx = 0; 
		for(int i=0;i<length;i++) {
			int j = i+1;
			int sum = arr[i];
			while(j<length) {
				sum+=arr[j];
				if(sum > max) {
					startIdx=i;endIdx=j;
					max=sum;
				}
				j++;
			}
		}
		printSolution(arr,max,startIdx,endIdx);
	}

	private static void printSolution(int[] arr, int max, int startIdx, int endIdx) {
		System.out.println("Max Sum is "+max+" between index "+startIdx+" and "+endIdx);
		for(int i=startIdx;i<=endIdx; i++) {
			System.out.println(arr[i]);
		}
	}

}
