package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

public class LowestCommonAncestorofaBirarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if(pVal > parentVal && qVal > parentVal)//means value of both p & q are greater than value of root and have to exist in right subtree of root
            return lowestCommonAncestor(root.right, p, q);
        if(pVal < parentVal && qVal < parentVal)//means value of both p & q are lower than value of root and have to exist in left subtree of root
            return lowestCommonAncestor(root.left, p, q);
        else //means one is lower and one is greater hence only root could be lowest ancestor
            return root;
    }
}
