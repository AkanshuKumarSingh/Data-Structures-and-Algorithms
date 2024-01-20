package BinarySearchTree;

public class _9_Check_for_BST {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	// 1st way
	public static class BSTPair {
		int min;
		int max;
		boolean isBST;

		BSTPair() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			isBST = true;
		}
	}

	public static BSTPair isBSTree(Node root) {
		if (root == null)
			return new BSTPair();

		BSTPair left = isBSTree(root.left);
		BSTPair right = isBSTree(root.right);

		boolean res = left.max < root.data && right.min > root.data;

		BSTPair mPair = new BSTPair();
		mPair.min = Math.min(root.data, Math.min(left.min, right.min));
		mPair.max = Math.max(root.data, Math.max(left.max, right.max));
		mPair.isBST = res && left.isBST && right.isBST;

		return mPair;

	}

	boolean isBST(Node root) {
		if (isBSTree(root).isBST)
			return true;
		return false;
	}

	// 2nd way
	int prev = Integer.MIN_VALUE;

	boolean isBST1(Node root) {
		// System.out.println("JSR");
		if (root == null) {
			return true;
		}
		if (!isBST1(root.left)) {
			return false;
		}
		if (prev >= root.data) {
			return false;
		}
		prev = root.data;

		return isBST1(root.right);
	}
}
