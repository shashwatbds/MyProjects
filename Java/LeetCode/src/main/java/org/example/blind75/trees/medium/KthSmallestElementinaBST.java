package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
* Tip: USes In order traversal: Left -> Root -> right
* */
public class KthSmallestElementinaBST {


    public List<Integer> inOrder(TreeNode root, List<Integer> arr, int k) {

        if(root == null)//This will happen when we are at left most element or the Tree itself is null.
            return arr;

        if(arr.size() == k)
            return arr;
        inOrder(root.left, arr, k);//In order traversal requires left node first, this method will keep on being called recursively until it is the left most element.
        arr.add((root.val));//First element added would be the left most element.
        inOrder(root.right, arr, k);//This is going to the right.
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inOrder(root, new ArrayList<>(), k);
        return nums.get(k-1);
    }
}
