package BinaryTree;

public class _52_Minimum_Depth_of_Binary_Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	int minDepth(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return 1;
		int l = minDepth(root.left), r = minDepth(root.right);
		return Math.min(l, r) + 1;
	}

}
