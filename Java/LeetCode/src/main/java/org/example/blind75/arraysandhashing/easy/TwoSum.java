package org.example.blind75.arraysandhashing.easy;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum object = new TwoSum();
        int[] target = object.getSum(new int[]{2, 1, 5, 3}, 4);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSum(new int[]{3, 2, 4}, 6);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSum(new int[]{3, 3}, 6);
        System.out.println(target[0] + " " + target[1]);

        System.out.println("\n\nBrute Force");
        target = object.getSumBruteForce(new int[]{2, 1, 5, 3}, 4);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSumBruteForce(new int[]{2, 7, 11, 15}, 9);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSumBruteForce(new int[]{3, 2, 4}, 6);
        System.out.println(target[0] + " " + target[1]);
        target = object.getSumBruteForce(new int[]{3, 3}, 6);
        System.out.println(target[0] + " " + target[1]);
    }

    /**
     * We can solve this in one loop by check for each iteration
     * This is also a dynamic programming solution since we have visited a node ( and saved in map ) then for each upcoming nodes all we have to find is if we have already visited target - current value
     * */
    private int[] getSum(int[] arr, int target) {
        //Time complexity - O(n) - only one loop
        //Space complexity - O(n) - we will have to add n-1 elements in worst case in hashmap.

        Instant start = Instant.now();
        int[] result = {-1, -1};
        Map<Integer, Integer> valueIdxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {// n time complexity
            if (valueIdxMap.containsKey(target - arr[i])) {
                result[0] = i;
                result[1] = valueIdxMap.get(target - arr[i]);
                break;
            } else {
                valueIdxMap.put(arr[i], i);
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute " + timeElapsed);
        return result;
    }

    private int[] getSumBruteForce(int[] arr, int target) {
        //Time complexity - O(n2) - two loops
        // Space Complexity - O(1) - no extra space needed.
        Instant start = Instant.now();
        int[] result = {-1, -1};

        for(int i =0; i<arr.length-1; i++) {// n complexity
            for(int j=1; j< arr.length; j++) {// n complexity
                if(arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute " + timeElapsed);

        return result;
    }
}
