package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
* Tip: USes In order traversal: Left -> Root -> right
* */
public class KthSmallestElementinaBSTOptimized {

    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return result;
    }

    private void kth(TreeNode root, int k) {
        if(root == null) return;
        kth(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        kth(root.right, k);
    }
}