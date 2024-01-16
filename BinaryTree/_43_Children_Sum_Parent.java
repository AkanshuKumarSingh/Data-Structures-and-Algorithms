package BinaryTree;

public class _43_Children_Sum_Parent {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static int isSumProperty(Node root) {
		if (root == null)
			return 1;
		if (root.left == null && root.right == null)
			return 1;
		if (isSumProperty(root.left) == 0)
			return 0;
		if (isSumProperty(root.right) == 0)
			return 0;
		int sum = (root.left == null ? 0 : root.left.data) + (root.right == null ? 0 : root.right.data);
		if (sum == root.data)
			return 1;
		return 0;
	}

}
