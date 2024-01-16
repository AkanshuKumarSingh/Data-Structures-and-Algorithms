package BinaryTree;

public class _29_Mirror_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void mirror(Node node) {
		if (node == null)
			return;
		Node t = node.left;
		node.left = node.right;
		node.right = t;

		mirror(node.left);
		mirror(node.right);
	}

}
