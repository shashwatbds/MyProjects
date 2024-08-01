package org.example.blind75.medium;

/**
 * Dynamic Programing: Uses Memoization, the art of storing values in a recursive function.
 *
 * */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequenceBF("abcde","ace"));
        System.out.println(obj.longestCommonSubsequenceBF("abc","abc"));
        System.out.println(obj.longestCommonSubsequenceBF("abc","def"));

        System.out.println("\n\n");

        System.out.println(obj.longestCommonSubsequenceMemoization("abcde","ace"));
        System.out.println(obj.longestCommonSubsequenceMemoization("abc","abc"));
        System.out.println(obj.longestCommonSubsequenceMemoization("abc","def"));

    }

    /**
     * https://www.youtube.com/watch?v=PieZjz2Pyhw&t=8879s
     * */
    public int longestCommonSubsequenceMemoization(String text1, String text2) {

        int[][] matrix = new int[text1.length()+1][text2.length()+1];//We have set size of array as 1 more than length to avoid null pointer exception.

        for(int j = text2.length()-1; j>=0; j--) {
            for(int i = text1.length()-1; i>=0; i--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    matrix[i][j] = 1 + matrix[i+1][j+1];//1 more than the diagonal
                } else {
                    matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j+1]);
                }
            }
        }
        return matrix[0][0];
    }

    /**
     * Brute force approach - In this case we won't use any memoization.
     * This approach has limitation that for longer strings java programs could go on running for a long duration and take up lot of space.
     * Time complexity - O(2^n) - at every single location we have two options.
     * */
    public int longestCommonSubsequenceBF(String text1, String text2) {
        return lcsRecursiveBF(text1, text2, text1.length(), text2.length());//Index for tracking chars on text1 and text2 respectively.
    }

    private int lcsRecursiveBF(String text1, String text2, int n, int m) {
        //Base case: stops recursion.
        if (n == 0 || m == 0)//This means we have reached end of one of the strings and can not further have a longer substring sequence.
            return 0;

        if (text1.charAt(n - 1) == text2.charAt(m - 1))//if char is same the index
            return 1 + lcsRecursiveBF(text1, text2, n - 1, m - 1);

        return Math.max(lcsRecursiveBF(text1, text2, n - 1, m), lcsRecursiveBF(text1, text2, n, m - 1));
    }
}
