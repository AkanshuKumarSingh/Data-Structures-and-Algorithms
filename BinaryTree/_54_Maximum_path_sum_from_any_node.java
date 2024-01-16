package BinaryTree;

public class _54_Maximum_path_sum_from_any_node {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static int sum = Integer.MIN_VALUE;

	int pathMaxSum(Node root) {
		if (root == null)
			return 0;
		int lSum = Math.max(0, pathMaxSum(root.left));
		int rSum = Math.max(0, pathMaxSum(root.right));
		sum = Math.max(sum, lSum + rSum + root.data);
		return Math.max(Math.max(lSum + root.data, rSum + root.data), 0);
	}

	int findMaxSum(Node node) {
		sum = Integer.MIN_VALUE;
		pathMaxSum(node);
		return sum;
	}
}
