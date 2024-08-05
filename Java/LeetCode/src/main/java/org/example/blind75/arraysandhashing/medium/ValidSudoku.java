package org.example.blind75.arraysandhashing.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        System.out.println(obj.isValidSudokuBruteForce(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        }));

        System.out.println(obj.isValidSudokuBruteForce(new char[][]{
                {'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        }));
    }

    /**
     * A valid sudoku has a single number (0-9) existing only once in a particular row, only once in particular column and only once in a 3*3 box.
     * For validating a valid sudoku we need to have this validation.
     * Time Complexity: O(n^2)
     * */
    private boolean isValidSudokuBruteForce(char[][] board) {

        Set<String> seen = new HashSet<>();//Clever trick: We are using this single hashset which will enable us to just have a single hashset to maintain uniqueness
        // in row, column and box in a single hashset instead of 3 different hashsets.
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char currentVal = board[i][j];
                if(!seen.add(currentVal + " found in row "+ i)
                        || !seen.add(currentVal + " found in column "+ j)
                        || !seen.add(currentVal + " sub box "+ i/3 +" - "+ j/3)){
                    return false;
                }

            }
        }
        return true;
    }
}
