package BinaryTree;

public class _81_Root_to_leaf_paths_sum {

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

	static long sum = 0;

	public static void findSum(Node root, long no) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			sum += (no * 10 + root.data);
			return;
		}

		findSum(root.left, no * 10 + root.data);
		findSum(root.right, no * 10 + root.data);
	}

	public static long treePathsSum(Node root) {
		sum = 0;
		findSum(root, 0);
		return sum;
	}

}
