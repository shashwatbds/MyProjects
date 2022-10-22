package medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(find(arr));
		
		int[] arr1 = {1,1};
		System.out.println(find(arr1));
		
	}

	private static int find(int[] arr) {
		int maxVol = 0;
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			int j=i+1;
			while(j<arr.length) {
				int vol = 0;
				vol = arr[i] * arr[j] * (j-i);
				if(vol>maxVol) {
					maxVol = vol;
					answer = (arr[i] < arr[j]) ? arr[i]*arr[i] : arr[j]*arr[j];
				}
				j++;
			}
		}
		return answer;
	}

}
