package org.example.blind75.trees.easy;

import org.example.blind75.trees.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    /**
     * Technique: Recursion, at each node we will find out maximum depth by comparing maximum depth of left node and right node.
     * Time Complexity: O(n) - we have to iterate over every item.
     * Space Complexity: O(n) - we might have to store each method.
     * */
    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;
        else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}
