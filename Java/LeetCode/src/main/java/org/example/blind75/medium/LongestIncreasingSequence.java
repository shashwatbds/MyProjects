package org.example.blind75.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Dynamic Programming
 * */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        LongestIncreasingSequence obj = new LongestIncreasingSequence();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

    /**
     * Time complexity is O(n)*O(n-1) = O(n^2) - because for each number we will compare the number with all its previous numbers.
     * */
    public int lengthOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;

        for(int i=1; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                    max = Math.max(lis[i], max);
                }
            }
        }
        return max;
    }


    /**
     * Time complexity is O(n)*O(n-1) = O(n^2) - because for each number we will compare the number with all its previous numbers.
     * */
    public int lengthOfLISRecursion(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;

        for(int i=1; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                    max = Math.max(lis[i], max);
                }
            }
        }
        return max;
    }

    /**
     * Time complexity is O(n)*O(n-1) = O(n^2) - because for each number we will compare the number with all its previous numbers.
     * */
    public int lengthOfLISRecursionMemoization(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;

        for(int i=1; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                    max = Math.max(lis[i], max);
                }
            }
        }
        return max;
    }
}
