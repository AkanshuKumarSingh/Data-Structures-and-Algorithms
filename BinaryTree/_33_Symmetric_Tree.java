package BinaryTree;

public class _33_Symmetric_Tree {

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

	public static boolean isMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		else if ((node1 == null && node2 != null) || (node1 != null && node2 == null))
			return false;
		else if (node1.data != node2.data)
			return false;
		return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}

	public static boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

}
