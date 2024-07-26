package org.example.blind75.easy;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(obj.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

        System.out.println("\n\n");

        System.out.println(obj.containsDuplicateSorted(new int[]{1,2,3,1}));
        System.out.println(obj.containsDuplicateSorted(new int[]{1,2,3,4}));
        System.out.println(obj.containsDuplicateSorted(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(obj.containsDuplicateSorted(new int[]{3,3}));
    }

    public boolean containsDuplicate(int[] nums) {//O(n)

        Instant start = Instant.now();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(visited.contains(nums[i])) {// fast access. O(1) for method contains method.
                return true;
            } else {
                visited.add(nums[i]);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute " + timeElapsed);
        return false;
    }

    public boolean containsDuplicateSorted(int[] nums) {//O(nlogn)

        Instant start = Instant.now();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute " + timeElapsed);
        return false;

    }
}
