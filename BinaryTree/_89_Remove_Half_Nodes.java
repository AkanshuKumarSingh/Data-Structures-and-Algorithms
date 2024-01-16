package BinaryTree;

public class _89_Remove_Half_Nodes {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static Node RemoveHalfNodes(Node root) {
		if (root == null)
			return null;
		else if (root.left == null && root.right != null) {
			return RemoveHalfNodes(root.right);
		} else if (root.left != null && root.right == null) {
			return RemoveHalfNodes(root.left);
		} else {
			root.left = RemoveHalfNodes(root.left);
			root.right = RemoveHalfNodes(root.right);
			return root;
		}
	}

}
