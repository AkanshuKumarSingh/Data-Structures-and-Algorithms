package BinarySearchTree;

public class _27_Delete_nodes_greater_than_k {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public Node deleteNode(Node root, int k) {
		if (root == null)
			return null;
		if (root.data >= k) {
			return deleteNode(root.left, k);
		} else {
			root.right = deleteNode(root.right, k);
			return root;
		}
	}

}
