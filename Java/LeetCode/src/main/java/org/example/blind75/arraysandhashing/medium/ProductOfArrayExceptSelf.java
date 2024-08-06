package org.example.blind75.arraysandhashing.medium;

import java.util.Arrays;

/***
 * Uses Kadane's algorithm, dynamic programming.
 * Uses prefix and postfix array
 * Why are we not allowed to use division operator - because in that case we will simply calculate the product of all items in array and then in one
 * traversal we will divide the product with current number and substitute the value, similar to two sum problem.
 * */
public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        System.out.println(obj.productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(obj.productExceptSelf(new int[]{-1,1,0,-3,3}));

    }

    /**
     * 1. Brute Force: This will have complexity o(n^2) since for each item we will traverse rest of the array and find product.
     * 2. Efficient way: Prefix and postfix. In reality the product at an index except self would be product of all elements of it's left(prefix)
     *                  with the product of all elements on the right(postfix) Example - in array (1,2,3,4,5} the product except self at index 2
     *                  will be product of all elements in it's prefix (index 0 &1) with the values in postfix of it(index 3 and 4)
     *                  Hence for solution, We will iterate the array twice, once in forward sequence second time in reverse to calculate pre fix and post fix values.
     * Time complexity is O(2n) ~ O(n)
     * For space complexity, we can initially have two different array prefix and post fix, calculate them both by iterating the array twice and then multiplying them both.
     * the time complexity would be O(3n) for efficient space complexity we can have it done in a single array and return that array.
     * In this way we will have complexity as O(1).
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
