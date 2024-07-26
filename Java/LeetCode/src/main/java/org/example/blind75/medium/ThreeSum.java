package org.example.blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();
        obj.threeSum(new int[] {-1,0,1,2,-1,-4}).forEach(innerList -> {
            System.out.println("List Contents");
            for(int i: innerList) {
                System.out.println(i);
            }
        });
        System.out.println("\n\n");

        obj.threeSum(new int[] {0,1,1}).forEach(innerList -> {
            System.out.println("List Contents");
            for(int i: innerList) {
                System.out.println(i);
            }
        });
        System.out.println("\n\n");

        obj.threeSum(new int[] {-0,0,0}).forEach(innerList -> {
            System.out.println("List Contents");
            for(int i: innerList) {
                System.out.println(i);
            }
        });
    }

    /**
     * Important: The only way we can find a triplet with sum 0 is by having a negative number in the triplet if we don't have that there is no point iterating forward.
     * */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);// Sorting an array
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {//avoid duplicate and does not give error on first element
                twoSum2(nums, i, result);
            }
        }
        return result;
    }


    private static void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        int left = i+1;
        int right = nums.length -1;

        while(left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if(sum < 0) { // If sum is negative and this is sorted array, the only way we can have sum closer to zero when left pointer is moved to right since the sum would increase.
                left++;
            } else if(sum > 0) {// If sum is negative and this is sorted array, the only way we can have sum closer to zero when right pointer is moved to left since the sum would decrease.
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while(left<right && nums[left] == nums[left-1]) {// if the next number is also same then skip it. this is to avoid duplicate triplets.
                    ++left;
                }
            }
        }
    }
}
