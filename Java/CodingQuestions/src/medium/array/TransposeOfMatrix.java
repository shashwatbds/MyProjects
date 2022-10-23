package medium.array;

public class TransposeOfMatrix {

	public static void main(String[] args) {

		int[][] matrix1 = new int[3][3];
		matrix1[0][0] = 1; matrix1[0][1] = 2;matrix1[0][2] = 3;
		matrix1[1][0] = 4; matrix1[1][1] = 5;matrix1[1][2] = 6;
		matrix1[2][0] = 7; matrix1[2][1] = 8;matrix1[2][2] = 9;

		// 0,0 -> 0,2
		// 0,1 -> 1,2
		// 0,2 -> 2,2
		// 1,0 -> 0,1 
		// 1,1 -> 1,1
		// 1,2 -> 2,1
		// 2,0 -> 0,0
		// 2,1 -> 1,0
		// 2,2 -> 2,0
		displayMatrix(matrix1);
		displayMatrix(convert(matrix1, 3));

	}
	
	public static void displayMatrix(int[][] matrix) {
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] convert(int[][] matrix, int n) {

		for(int i=0; i< matrix.length; i++) {
			for(int j=i; j< matrix[i].length; j++) {
				if(i!=j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		return matrix;
	}

}
