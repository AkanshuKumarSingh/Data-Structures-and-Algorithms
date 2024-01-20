package BinarySearchTree;

public class _16_Search_node_in_BST {

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

	boolean search(Node root, int x) {
		if (root == null)
			return false;
		if (root.data == x)
			return true;
		else if (root.data < x)
			return search(root.right, x);
		else
			return search(root.left, x);
	}

}
