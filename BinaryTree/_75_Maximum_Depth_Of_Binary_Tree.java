package BinaryTree;

public class _75_Maximum_Depth_Of_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static int maxDepth(Node root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

	}

}
