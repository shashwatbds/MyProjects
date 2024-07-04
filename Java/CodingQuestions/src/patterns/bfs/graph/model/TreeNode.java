package patterns.bfs.graph.model;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * if n is the number of nodes in the tree, the time complexity of the algorithm will be O(n).
 * */
public class TreeNode<T> {

    private TreeNode<T> left;
    private TreeNode<T> right;
    private T value;

    public TreeNode (T value, TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <T> Optional<TreeNode<T>> searchTree(T searchValue, TreeNode<T> inputTree) {
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(inputTree);

        while(!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();
            if(currentNode.value.equals(searchValue)) {
                return Optional.of(currentNode);
            } else {
                queue.add(currentNode.right);
                queue.add(currentNode.left);
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(2, new TreeNode<Integer>(3, null, null), new TreeNode<Integer>(4, null, null));
        System.out.println(Optional.of(TreeNode.searchTree(4, root).get().value));
    }
}
