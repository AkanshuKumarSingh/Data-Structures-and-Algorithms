package BinaryTree;

public class _77_Expression_Tree {

	static class Node {
		String data;
		Node left, right;

		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public int evalTree(Node root) {
		if (root.left == null && root.right == null)
			return Integer.parseInt(root.data);

		int left = evalTree(root.left);
		int right = evalTree(root.right);

		if (root.data.equals("+")) {
			return left + right;
		} else if (root.data.equals("-")) {
			return left - right;
		} else if (root.data.equals("*")) {
			return left * right;
		} else {
			return left / right;
		}

	}

}
