package BinarySearchTree;

public class _11_Inorder_Successor_in_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	int state = 0;

	public Node inorderSuccessor(Node root, Node x) {
		if (root == null)
			return null;
		Node l = inorderSuccessor(root.left, x);
		if (l != null)
			return l;
		if (state == 0) {
			if (root == x)
				state++;
		} else if (state == 1) {
			return root;
		}
		return inorderSuccessor(root.right, x);
	}

}
