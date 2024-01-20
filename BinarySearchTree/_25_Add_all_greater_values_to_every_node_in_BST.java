package BinarySearchTree;

public class _25_Add_all_greater_values_to_every_node_in_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int sum = 0;

	public Node modify(Node root) {
		if (root == null)
			return null;
		modify(root.right);
		sum += root.data;
		root.data = sum;
		modify(root.left);
		return root;
	}

}
