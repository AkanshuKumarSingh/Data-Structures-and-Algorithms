package BinaryTree;

public class _90_Transform_to_Sum_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public int sum(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			int no = root.data;
			root.data = 0;
			return no;
		}
		int lSum = sum(root.left);
		int rSum = sum(root.right);
		int no = root.data;
		root.data = lSum + rSum;
		return no + root.data;
	}

	public void toSumTree(Node root) {
		sum(root);
	}

}
