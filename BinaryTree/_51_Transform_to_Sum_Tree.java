package BinaryTree;

public class _51_Transform_to_Sum_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public int transform(Node root) {
		if (root == null)
			return 0;
		int left = transform(root.left);
		int right = transform(root.right);
		int t = root.data;
		root.data = left + right;
		return root.data + t;
	}

	public void toSumTree(Node root) {
		transform(root);
	}

}
