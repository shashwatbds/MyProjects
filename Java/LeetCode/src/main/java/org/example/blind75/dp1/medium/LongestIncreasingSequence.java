package org.example.blind75.dp1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Dynamic Programming
 * */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        LongestIncreasingSequence obj = new LongestIncreasingSequence();
        System.out.println(4 == obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(4 == obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(1 == obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));

        System.out.println(4 == obj.lengthOfLISBinarySearch(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(4 == obj.lengthOfLISBinarySearch(new int[]{0,1,0,3,2,3}));
        System.out.println(1 == obj.lengthOfLISBinarySearch(new int[]{7,7,7,7,7,7,7}));
    }

    /**
     * Time complexity is O(n)*O(n-1) = O(n^2) - because for each number we will compare the number with all its previous numbers.
     * */
    public int lengthOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;

        for(int i=1; i< nums.length; i++) {//start with 2nd element so that we can compare it with first element. value at first element will always be 1.
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);//recurrence relation = Interview Term to be used.
                    max = Math.max(lis[i], max);
                }
            }
        }
        return max;
    }


    /**
     * Time complexity is O(nlogn) - because for will iterate the array once so n and for binary search it would be nlogn so total complexity is n+ nlogn which is similar to O(nlogn)
     * */
    public int lengthOfLISBinarySearch(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the first element of nums
        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                // If the current number is greater than the last element of the answer
                // list, it means we have found a longer increasing subsequence.
                // Hence, we append the current number to the answer list.
                ans.add(nums[i]);
            } else {
                // If the current number is not greater than the last element of the answer list, we perform
                // a binary search to find the smallest element in the answer list that is greater than or equal to the
                // current number.
                // The binarySearch method returns the index of the first element that is not less than the current number.
                int low = Collections.binarySearch(ans, nums[i]);

                // We update the element at the found position with the current number.
                // By doing this, we are maintaining a sorted order in the answer list.
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, nums[i]);
            }
        }
        // The size of the answer list represents the length of the longest increasing subsequence.
        return ans.size();
    }
}
