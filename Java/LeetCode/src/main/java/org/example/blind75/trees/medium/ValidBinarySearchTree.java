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

        if(!inOrder(root.left))//left traversal recursively - will return true at the left most deep node.
            return false;

        if(prev != null && root.val <= prev)//This means if it's not the first iteration and in this case since left will be prev of root and hence can not be greater than root.
            return false;//This will only compare root value with some value on root's right node because prev would be set to root or when prev is set to left node then we are at root.

        prev = root.val;//Once left most node is traversed in the subtree then we set prev as root and progress to right subtree now
        return inOrder(root.right);//this will go to right but on right node too it will try to go to the left most node in depth. for left most
    }


    public static void main(String[] args) {

        ValidBinarySearchTree tree = new ValidBinarySearchTree();
        TreeNode five = new TreeNode(5);
        TreeNode one2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        TreeNode four2 = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode six2 = new TreeNode(6);
        TreeNode seven2 = new TreeNode(7);
        TreeNode eight2 = new TreeNode(8);

        four2.left = two2;
        two2.left = one2;
        two2.right = three2;
        four2.right = six2;
        six2.left = five;
        six2.right = eight2;
        eight2.left = seven2;
        System.out.println(Boolean.TRUE.equals(tree.isValidBST(four2)));

        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        four.left = three;
        four.right = six;
        root.left = one;
        root.right = four;
        System.out.println(Boolean.FALSE.equals(tree.isValidBST(root)));

        TreeNode two = new TreeNode(2);
        TreeNode one1 = new TreeNode(1);
        TreeNode three3 = new TreeNode(3);
        two.left = one1;
        two.right = three3;
        System.out.println(Boolean.TRUE.equals(tree.isValidBST(two)));

    }
}
