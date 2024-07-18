package org.example.blind75.medium;

public class MaximumSubarray {

    public static void main(String[] args) {

        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(obj.maxSubArray(new int[]{1}));
        System.out.println(obj.maxSubArray(new int[]{5,4,-1,7,8}));

    }


    public int maxSubArray(int[] nums) {

        int maxSum = nums[0], curSum = nums[0];
        for(int i=1; i< nums.length; i++) {
            curSum = Math.max(nums[i]+curSum, nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
