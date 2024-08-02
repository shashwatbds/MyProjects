package org.example.blind75.dp1.medium;

/**
 * https://www.youtube.com/watch?v=Y6B-7ZctiW8
 * */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(obj.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(obj.maxProduct(new int[]{-2,0,-1}));
        System.out.println(obj.maxProduct(new int[]{-2,3,-4}));
        System.out.println(obj.maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int leftProduct = 1, rightProduct = 1;
        int ans = nums[0];
        for(int i=0; i<n; i++) {

            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }
}
