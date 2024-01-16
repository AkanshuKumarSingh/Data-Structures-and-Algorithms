package BinaryTree;

public class _23_Sum_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static boolean flag = true;

	static int sum(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		int left = sum(root.left);
		int right = sum(root.right);
		if (left + right != root.data)
			flag = false;
		return left + right + root.data;
	}

	boolean isSumTree(Node root) {
		flag = true;
		sum(root);
		return flag;
	}

}
