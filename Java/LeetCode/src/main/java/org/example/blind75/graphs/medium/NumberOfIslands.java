package org.example.blind75.graphs.medium;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int row = grid.length;//to fix bound of loop
        int col = grid[0].length;//to fix bound of loop

        int islands = 0;

        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                if(grid[i][j] == '1') {//We will only be finding neighbouring 1s recursively when we get a item with value '1'
                    islands++;//Increment as soon as we find the first 1.
                    dfs(i, j, grid);//we will now iteratively find it's neighbouring 1's
                }
            }
        }
        return islands;
    }

    private void dfs(int row, int col, char[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//Static array to find neighbours, represents one on the right,
        // one on the left, one on above and one below the current node respectively.
        if(row<0 || col <0 || row>=newRow || col >= newCol || grid[row][col] == '0') {//terminating condition of the recursion,
            // this check if column of array are out of bounds of the grid itself.
            // or have encountered a '0'
            return;
        }
        grid[row][col] = '0';
        for(int[] dir: directions) {//finding neighbours using static directions array.
            dfs(row+dir[0], col+dir[1], grid);
        }
    }

    public static void main(String[] args) {
    }
}
