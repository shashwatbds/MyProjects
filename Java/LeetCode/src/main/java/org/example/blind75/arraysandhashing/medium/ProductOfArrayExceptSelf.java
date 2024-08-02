package org.example.blind75.arraysandhashing.medium;

import java.util.Arrays;

/***
 * Uses Kadane's algorithm, dynamic programming.
 * Uses prefix and postfix array
 * */
public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        System.out.println(obj.productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(obj.productExceptSelf(new int[]{-1,1,0,-3,3}));

    }

    /**
     * We will iterate the array twice, once in forward sequence second time in reverse to calculate pre fix and post fix values
     * Hence the time complexity is O(2n) ~ O(n)
     * */
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);//in prefix first value in array will always be 1
        int pre=1, post=1;// initialized to 1 so that for the left most and right most values in array we don't have
        // to handle them not having any values to multiply by

        //prefix population
        for(int i=0; i<nums.length; i++) {
            result[i] = pre;
            pre = nums[i]*pre;
        }
        //postfix population
        for(int j=result.length-1; j>=0; j--) {
            result[j] = post*result[j];
            post = post * nums[j];
        }
        return result;
    }
}
