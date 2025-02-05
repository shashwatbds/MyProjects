package org.example.blind75.trees.traversal;

import org.example.blind75.trees.TreeNode;

import java.util.Objects;

public class PreorderTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode root) {

        if(Objects.isNull(root))
            return;

        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
