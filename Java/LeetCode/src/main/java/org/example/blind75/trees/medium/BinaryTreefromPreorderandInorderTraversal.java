package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreefromPreorderandInorderTraversal {

    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderIndexMap = new HashMap();//This will allow us to iterate over the in order array very fast.

    public  TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);

        return arrayToTree(preorder, 0, preorder.length-1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left>right)
            return null;

        int rootValue = preorder[preOrderIndex];//Root for each sub-problem, initially this would be the first value in the index.
        preOrderIndex++;

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue)-1);
        root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue)+1, right);

        return root;
    }
}
