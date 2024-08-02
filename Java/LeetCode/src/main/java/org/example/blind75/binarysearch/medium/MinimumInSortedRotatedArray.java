package org.example.blind75.binarysearch.medium;

/***Solution based on two pointer solution*/
public class MinimumInSortedRotatedArray {

    //Solve in O(logn) - as soon as we get log(n) complexity we know this will be solved by binary search.
    //In each iteration we will discard half of the elements from consideration hence the time complexity is logn

    public static void main(String[] args) {
        MinimumInSortedRotatedArray obj = new MinimumInSortedRotatedArray();
        System.out.println(obj.findMin(new int[]{3,4,5,1,2}));
        System.out.println(obj.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(obj.findMin(new int[]{11,13,15,17}));
        System.out.println(obj.findMin(new int[]{2,1}));
    }

    /**
     * Had we sorted the array then the complexity would not have remained log(n) since this would required just for sorting.
     * We will maintain 2 pointers and compare both to find if left pointer is less than right pointer.
     *  - if l < r, we can assume range l and r is sorted and l is minimum in the range.
     *  - if l > r then minimum lies between l and r but not at l or r.
     *      - We find middle value and if the middle value is > r then the minimum lies between middle and r else it lies between l and middle.
     * */
    public int findMin(int[] nums) {

        int ans = nums[0], left = 0, right = nums.length-1;
        if(nums.length == 1) {
            return nums[0];
        }

        while(left <= right) {// The loop will stop when two adjacent numbers are being matched.
            if(nums[left] < nums[right]) {// This will only be true in the last iteration when left most will always be greater than last one. This will also be true for non rotated fully sorted array.
                ans = Math.min(ans, nums[left]);
            }
            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);
            if(nums[left] <= nums[mid]) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return ans;
    }
}
