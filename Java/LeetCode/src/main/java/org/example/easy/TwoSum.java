package org.example.easy;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) { //Two Loops causing issue
        Instant start = Instant.now();
        int[] result = new int[2];
        int i=0;
        while(i<nums.length) {
            for(int j = i+1; j<nums.length; j++) {
                if(target == nums[i]+nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
            i++;
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute "+timeElapsed);
        return result;
    }

    public int[] twoSumEfficient(int[] nums, int target) {
        Instant start = Instant.now();
        int[] result = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(numToIndex.containsKey(target - nums[i])) {
                return new int[]{ numToIndex.get(target-nums[i]), i};
            }
            numToIndex.put(nums[i], i);//This is the key, only one loop, and we are not running another loop to add items in the loop.
            //This was only possible because we had two numbers combining to form result.
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time taken to execute efficient "+timeElapsed);
        return result;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] result = obj.twoSum(new int[]{2,7,11,15},9);
        System.out.println(result[0] + " "+result[1]);

        result = obj.twoSum(new int[]{3,2,4},6);
        System.out.println(result[0] + " "+result[1]);

        result = obj.twoSum(new int[]{3,3},6);
        System.out.println(result[0] + " "+result[1]);

        System.out.println("\n\nEfficient Solution\n\n");

        result = obj.twoSumEfficient(new int[]{2,7,11,15},9);
        System.out.println(result[0] + " "+result[1]);

        result = obj.twoSumEfficient(new int[]{3,2,4},6);
        System.out.println(result[0] + " "+result[1]);

        result = obj.twoSumEfficient(new int[]{3,3},6);
        System.out.println(result[0] + " "+result[1]);
    }
}
