package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

public class ValidBinarySearchTree {

    public Integer prev;

    public boolean isValidBST(TreeNode root) {

        prev = null;
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {
        if(root == null)
            return true;

        if(!inOrder(root.left))
            return false;

        if(prev != null && root.val <= prev)//This means if it's not the first iteration and
            return false;

        prev = root.val;
        return inOrder(root.right);
    }
}
