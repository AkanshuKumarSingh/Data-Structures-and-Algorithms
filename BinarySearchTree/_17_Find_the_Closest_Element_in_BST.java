package BinarySearchTree;

public class _17_Find_the_Closest_Element_in_BST {

	static class Node {
		int data;
		Node left, right;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static int minDiff(Node root, int K) {
		if (root == null)
			return Integer.MAX_VALUE / 100;
		int l = Integer.MAX_VALUE / 100, r = Integer.MAX_VALUE / 100;
		if (root.data - K > 0) {
			l = minDiff(root.left, K);
		} else {
			r = minDiff(root.right, K);
		}
		int ans = Math.min(Math.min(l, r), Math.abs(root.data - K));
		return ans;
	}
}
