package org.example.blind75.trees.medium;

import org.example.blind75.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> ans = new ArrayList<>();//declared global since we need new method which we will call recursively.

    /**
     * This method will populate the answer list.
     * */
    public void order(TreeNode node, int level) {

        if(ans.size() == level) // creating new entry for new level
            ans.add(new ArrayList<Integer>());

        ans.get(level).add(node.val);
        //check if left child and right child exist, if yes call this method recursively.
        if(node.left != null)
            order(node.left, level+1);
        if(node.right != null)
            order(node.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return ans;
        order(root, 0);
        return ans;
    }
}
