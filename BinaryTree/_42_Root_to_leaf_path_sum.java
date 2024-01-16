package BinaryTree;

public class _42_Root_to_leaf_path_sum {

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

	boolean hasPathSum(Node root, int S) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (root.data == S)
				return true;
			return false;
		}
		if (S < 0)
			return false;

		return hasPathSum(root.left, S - root.data) || hasPathSum(root.right, S - root.data);
	}

}
