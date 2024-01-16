package BinaryTree;

public class _82_Maximum_sum_leaf_to_root_path {

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

	public static int maxPathSum(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		return Math.max(maxPathSum(root.left), maxPathSum(root.right)) + root.data;
	}

}
