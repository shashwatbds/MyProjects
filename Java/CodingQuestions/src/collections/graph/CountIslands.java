package collections.graph;

public class CountIslands {

	private static final int ROW = 5, COL = 5;

	private boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >=0) && row < ROW && col >= 0 && col < COL && (M[row][col] == 1 && visited[row][col]);
	}

	private void DFS(int M[][], int row, int col, boolean visited[][]) {
		int rowNbr[] = new int[] {-1,-1,-1,0,0,1,1,1};
		int colNbr[] = new int[] {-1,0,1,-1,1,-1,0,1};

		visited[row][col]  = true;
		
		for(int k =0; k < 8; ++k) {
			if(isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}
	
	private int countIslands(int M[][]) {
		boolean visited[][] = new boolean[ROW][COL];
		
		int count = 0;
		for(int i=0; i<ROW; ++i) {
			for(int j=0; j < COL; ++j) {
				if(M[i][j] == 1 && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int M[][] = new int[][] {
			{1,1,0,0,0},
			{0,1,0,0,1},
			{1,0,0,1,1},
			{0,0,0,0,0},
			{1,0,1,0,1}
		};
		
		CountIslands i = new CountIslands();
		System.out.println(i.countIslands(M));
	}

}
