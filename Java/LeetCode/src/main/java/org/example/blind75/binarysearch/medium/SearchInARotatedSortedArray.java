package org.example.blind75.binarysearch.medium;

/**
 * Solution based on two pointer solution
 * */
public class SearchInARotatedSortedArray {

    public static void main(String[] args) {
        SearchInARotatedSortedArray obj = new SearchInARotatedSortedArray();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[]{1}, 0));
    }


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
                if(target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                if(target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
