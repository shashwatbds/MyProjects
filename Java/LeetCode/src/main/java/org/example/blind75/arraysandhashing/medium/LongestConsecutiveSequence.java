package org.example.blind75.arraysandhashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
//        System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2}) == 4);
//        System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}) == 9);
//        System.out.println(obj.longestConsecutive(new int[]{2,20,4,10,3,4,5}) == 4);
        System.out.println(obj.longestConsecutive(new int[]{2, 3, 4, 5}) == 4);
//        System.out.println(obj.longestConsecutive(new int[]{0,3,2,5,4,6,1,1}) == 7);
    }

    /**
     * 1. For brute force approach - for each number in the array we will check if a number greater than that particular number exits, if it does not
     * then we can exit the loop and move to the next number and repeat the same process. If we find the next number then we again try to find the next
     * number in the array, for each positive n, we iterate another n elements and then if we find a match then we find again, so in short the
     * complexity of brute force approach is O(n^3)
     *
     * 2. Better Approach: Sort the input array and then find the common subsequence by avoiding duplicates. Time complexity for this would be O(nlongn)
     *
     * 3. Efficient approach:
     *          - Add all elements in hashset, this will remove duplicates automatically.
     *          - In brute force approach we were checking subsequence for all elements but we only need to find subsequence if we think this is start
     *                  of a subsequence, we can assume a number can be a start of subsequence only if one lower element does not exist in the hashset.
     *                  i.e we do not compute subsequence logic in element 3,2,1 in an array 0,3,7,2,5,8,4,6,0,1 simply because it can not be start of
     *                  a subsequence since we have one lesser element than them in the array (and hashset)
     *
     *          - Important: The while loop inside the for loop can make you think that it is a O(n²) solution, but it is not. The reason being the inner while loop does not run for every i of the for loop.
     * */
    public int longestConsecutive(int[] nums) {

        // Step 1: Handle the base case when the array is empty.
        if(nums.length == 0)
            return 0;

        // Step 2: Insert all elements of 'nums' into the hash set 'set'.
        Set<Integer> uniqueNums = new HashSet<>();// Whenever you are looking for unique numbers use hashset, it has constant time lookup as well.
        for(int i : nums)
            uniqueNums.add(i);

        int lcs = 1;// Initialize a variable to store the maximum consecutive sequence length.
        // Step 3: Iterate through the elements of 'nums'.
        for(int num: nums) {
            // Step 4: If the current element 'num' is the start of a sequence (no 'num-1' in 'set'),
            if(uniqueNums.contains(num-1)){// This could be beginning of a new subsequence.
                continue;
            } else {
                int currentNumber = num;
                int cs = 1;// Initialize a counter for the current consecutive sequence length.
                // Step 5: While consecutive elements exist in 'uniqueNums', increment 'cs' and 'currentNum'.
                while(uniqueNums.contains(currentNumber+1)) {// The while loop inside the for loop can make you think that it is a O(n²) solution, but it is not. The reason being the inner while loop does not run for every i of the for loop.
                    currentNumber+=1;
                    cs+=1;
                }
                lcs = Math.max(lcs, cs);
            }
            if(lcs > nums.length/2) break;// Very Important: because, no if we already have a subsequence greater than half of the size then no other subsequence could exits with longer length.
        }
        return lcs;
    }
}
