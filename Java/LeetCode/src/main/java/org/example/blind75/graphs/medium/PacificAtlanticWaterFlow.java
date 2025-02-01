package org.example.blind75.graphs.medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if(heights.length == 0 || heights[0].length == 0)
            return new ArrayList<>();


        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            dfs(i, 0, pacificReachable, heights);// traversing from top of the grid (row 0)
            dfs(i, col-1, atlanticReachable, heights);//traversing from bottom of the grid(row-1)
        }
        for(int i = 0; i < col; i++) {
            dfs(0, i, pacificReachable, heights);// traversing from top of the grid (row 0)
            dfs(row-1, i, atlanticReachable, heights);//traversing from bottom of the grid(row-1)
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if(atlanticReachable[i][j] && pacificReachable[i][j])
                    result.add(List.of(i,j));
            }
        }

        return result;
    }

    private void dfs(int row, int column, boolean[][] reachableGrid, int[][] heights) {

        int[][] directions = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};//Helper for check up, down, left and right cells of the current cell.

        reachableGrid[row][column] = true;//For the corner rows all cells will have this true by default.
        for(int[] direction : directions) {//Checking all 4 directions one by one.
            int newRow = row+direction[0];
            int newColumn = column+direction[1];
            if(newRow < 0 || newRow >= heights.length || newColumn < 0 || newColumn >= heights[0].length) {//Checking out of bounds
                continue;//because we still want to check in other directions
            }

            if(reachableGrid[newRow][newColumn]) {//If already visited then ignore
                continue;//because we still want to check in other directions
            }
            if(heights[newRow][newColumn] >= heights[row][column]) {//We will call this method recursively only when value is higher in new cell.
                dfs(newRow, newColumn, reachableGrid, heights);
            }
        }
    }
}
