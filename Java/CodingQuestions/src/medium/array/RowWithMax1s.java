package medium.array;

public class RowWithMax1s {

	public static void main(String[] args) {
		int arr[][] = {{0,1,1,1},
				{0,0,1,1},
				{1,1,1,1},
				{0,0,0,0}
		};
		find(arr);
	}

	private static void find(int[][] arr) {

		System.out.println(arr.length);
		int maxIndex = 0, intMaxCount = 0;
		for(int i=0; i<arr.length; i++) {
			int count=0;
			for(int j=0; j<arr[i].length;j++) {
				if(arr[i][j]==1) {
					count++;
				}
			}
			if(count>intMaxCount) {
				intMaxCount=count;
				maxIndex = i;
			}
		}
		System.out.println("Max count "+intMaxCount+" at index "+maxIndex);
	}

}
