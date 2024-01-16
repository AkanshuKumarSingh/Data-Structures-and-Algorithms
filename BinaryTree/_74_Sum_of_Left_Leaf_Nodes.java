package BinaryTree;

public class _74_Sum_of_Left_Leaf_Nodes {

	static class Node {
		int data;
		Node left, right;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int leftSum(Node root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if (isLeft)
				return root.data;
			return 0;
		}
		return leftSum(root.left, true) + leftSum(root.right, false);
	}

	public int leftLeavesSum(Node root) {
		return leftSum(root, false);
	}

}
