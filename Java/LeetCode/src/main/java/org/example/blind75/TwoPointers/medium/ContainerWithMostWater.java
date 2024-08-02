package org.example.blind75.TwoPointers.medium;

/**
 * We will use two pointer approach here which will give us the time complexity of O(n)
 * Had we used brute force then we would have used two loops and the time complexity would have been O(n2)
 * Space complexity is O(n) since we are only using two pointers.
 * */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(obj.maxArea(new int[] {1,1}));
    }

    public int maxArea(int[] height) {

        int max = 0, left = 0, right = height.length-1;

        while(left<right) {
            int width = right-left;
            int area = Math.min(height[left], height[right]) * width;
            max = Math.max(area, max);
            if(height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return max;
    }
}
