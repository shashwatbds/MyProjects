package org.example.blind75.trees.easy;

import org.example.blind75.trees.TreeNode;

public class InvertBinaryTree {

    /**
     * Time Complexity: O(n) since we are accessing every node of the binary tree once.
     * Space Complexity: O(h): height of the tree, we will store few values on temp variables.
     * */
    public TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;

        return root;
    }
}
