package collections.binarytree;

public class BinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2); root.right = new Node(3);
		root.left.left = new Node(4); root.left.right = new Node(5);root.right.left = new Node(6); root.right.right = new Node(7);
		root.left.left.left = new Node(8);root.right.left.left = new Node(9); root.right.left.right = new Node(10);
		System.out.println(depthFirstSearch(root, 7));
		System.out.println(depthFirstSearch(root, 6));
		System.out.println(depthFirstSearch(root, 11));
		System.out.println(depthFirstSearch(root, 2));
		numberOfTurns(root, 1,4);
	}

	private static void numberOfTurns(Node root, int first, int second) {
		int firstDepth, secondDepth;

	}

	public static boolean depthFirstSearch(Node node, int data) {//Pre-order traversal

		if(node == null) {
			return false;
		}else {
			if(node.data == data) {
				return true;
			}
			boolean lRes = depthFirstSearch(node.left, data);
			if(lRes) return true;
			boolean rRes = depthFirstSearch(node.right, data);
			return rRes;
		} 
	}


}
