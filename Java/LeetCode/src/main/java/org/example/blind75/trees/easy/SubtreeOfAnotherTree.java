package org.example.blind75.trees.easy;

import org.example.blind75.trees.TreeNode;

public class SubtreeOfAnotherTree {

    /**
     * This method will help find if the subtrees are same once we have found the subtree's root node in base tree.
     * */
    public boolean isSame(TreeNode t, TreeNode s) {
        if(t == null && s == null)
            return true;
        if(t == null || s == null)
            return false;

        if(t.val != s.val)
            return false;

        return isSame(t.left, s.left) && isSame(t.right, s.right);
    }

    /**
     * Try to find the base subtree
     * */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null)
            return false;
        if(isSame(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
