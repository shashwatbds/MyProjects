package org.example.easy;

public class MaximumSumForSubarrayOfSizeK {

    public static void main(String[] args) {
        MaximumSumForSubarrayOfSizeK object = new MaximumSumForSubarrayOfSizeK();
        System.out.println(object.maxSum(new int[]{ 1, 4, 2, 10, 2, 3, 1, 0, 20 }, 4));
        System.out.println(object.maxSum(new int[]{ 100, 200, 300, 400 }, 2));
        System.out.println(object.maxSum(new int[]{ 2, 3 }, 3));
    }

    public int maxSum(int arr[], int k) {

        int n = arr.length;
        if(n < k) {
            return 0;
        }
        int currSum = 0, maxSum = 0;
        for(int i=0; i<=n-k; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

}
