package org.example.blind75.trees.traversal;

import org.example.blind75.trees.TreeNode;

import java.util.Objects;

public class Postorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        postorderTraversal(root);
    }

    private static void postorderTraversal(TreeNode root) {

        if(Objects.isNull(root))
            return;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }
}
