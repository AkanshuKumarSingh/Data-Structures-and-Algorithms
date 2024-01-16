package BinaryTree;

public class _102_Height_of_Spiral_Tree {

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

	public static int findTreeHeight(Node root) {
		if (root == null)
			return 0;
		if (root.left != null && root.left.right == root)
			return 1;
		int left = findTreeHeight(root.left);
		int right = findTreeHeight(root.right);
		int max = Math.max(left, right) + 1;
		return max;
	}

}
