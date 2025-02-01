package org.example.blind75.dp2.medium;

public class HouseRobber {

    public int rob(int[] nums) {

        int rob1 = 0;//Maximum Value in one prev location
        int rob2 = 0;//Maximum value at one index 1 less than i
        int max = 0;//Holds max which we update in loop.

        for(int i=0; i< nums.length; i++) {
            max = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }
}
