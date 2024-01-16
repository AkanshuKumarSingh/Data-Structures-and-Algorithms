package BinaryTree;

public class _48_Leaf_at_same_level {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static int level = -1;
	static boolean sameLevel = true;

	void traverse(Node root, int ht) {
		if (!sameLevel)
			return;
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (level == -1) {
				level = ht;
			} else if (level != ht) {
				sameLevel = false;
			}
			return;
		}

		traverse(root.left, ht + 1);
		traverse(root.right, ht + 1);
	}

	boolean check(Node root) {
		level = -1;
		sameLevel = true;
		traverse(root, 0);
		return sameLevel;
	}

}
