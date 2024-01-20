package BinarySearchTree;

public class _28_Remove_BST_keys_outside_given_range {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node removekeys(Node root, int l, int r) {
		if (root == null)
			return null;
		if (root.data < l) {
			return removekeys(root.right, l, r);
		} else if (root.data > r) {
			return removekeys(root.left, l, r);
		} else {
			root.left = removekeys(root.left, l, r);
			root.right = removekeys(root.right, l, r);
			return root;
		}
	}

}
