package BinaryTree;

public class _53_Maximum_difference_between_node_and_its_ancestor {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static int maxValue = Integer.MIN_VALUE;

	int min(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		int l = min(root.left);
		int r = min(root.right);
		int currMin = Math.min(l, r);
		maxValue = Math.max(maxValue, root.data - currMin);
		return Math.min(currMin, root.data);
	}

	int maxDiff(Node root) {
		maxValue = Integer.MIN_VALUE;
		min(root);
		return maxValue;
	}

}
