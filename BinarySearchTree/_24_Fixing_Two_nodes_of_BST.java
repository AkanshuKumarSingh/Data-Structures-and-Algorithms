package BinarySearchTree;

public class _24_Fixing_Two_nodes_of_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node prev = null, first = null, second = null;

	public void find(Node root) {
		if (root == null)
			return;

		find(root.left);
		if (prev != null && prev.data > root.data) {
			if (first == null) {
				first = prev;
				second = root;
			} else {
				second = root;
			}
		}
		prev = root;
		find(root.right);
	}

	public Node correctBST(Node root) {
		find(root);
		int t = first.data;
		first.data = second.data;
		second.data = t;
		return root;
	}

}
