package org.example.blind75.easy;

/**
 * This is classic dynamic programming problem.
 * For each step we will save the number of routes possible at each stair and we can avoid recalculation everytime.
 * In this manner we will be able to have time complexity of O(n)
 * Brute force method will be recursion. Time complexity will be 2^n since for each node we will have two different options, 1 step or 2 steps.
 * */
public class ClimbingSteps {

    public static void main(String[] args) {

        ClimbingSteps obj = new ClimbingSteps();
        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
    }

    public int climbStairs(int n) {

        if(n == 1) {
            return 1;
        }
        int one = 1, two = 2;//Representing number of way we can reach 1st stair and second stair respectively, this will never change
        for(int i = 3; i<=n; i++) {// We will start calculating the number of ways to reach remaining steps from step number 3 onwards.

            int total = one + two; //The number of ways we can reach ith step is the sum of number of ways we can reach i-1 step and i-2 steps.
            one = two;
            two = total;
        }
        return two;
    }
}
