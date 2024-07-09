package org.example.easy;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0], currentSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
        System.out.println(obj.maxSubArray(new int[]{1}));//1
        System.out.println(obj.maxSubArray(new int[]{5,4,-1,7,8}));//23
        System.out.println(obj.maxSubArray(new int[]{-1}));//-1
    }
}
