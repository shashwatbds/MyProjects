package org.example.blind75.dp1.medium;

/**
 * https://www.youtube.com/watch?v=Y6B-7ZctiW8
 * */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(6 == obj.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(0 == obj.maxProduct(new int[]{-2,0,-1}));
        System.out.println(24 == obj.maxProduct(new int[]{-2,3,-4}));
        System.out.println(1981284352 == obj.maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }

    public int maxProduct(int[] nums) {

        if(nums.length == 0)
            return 0;

        int min = nums[0];
        int max = nums[0];
        int result = max;
        for(int i=1; i< nums.length; i++) {

            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(max*curr, min*curr));//because we need to also calculate new min in next step using old max value.
            min = Math.min(curr, Math.min(max*curr, min*curr));
            max = tempMax;//assign to new max.
            result = Math.max(max, result);
        }
        return result;
    }
}
