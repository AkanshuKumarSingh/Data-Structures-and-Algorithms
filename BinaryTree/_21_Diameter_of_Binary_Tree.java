package BinaryTree;

public class _21_Diameter_of_Binary_Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static int diameter = 0;

	int findDiameter(Node root) {
		if (root == null)
			return -1;
		int left = findDiameter(root.left);
		int right = findDiameter(root.right);
		diameter = Math.max(left + right + 3, diameter);
		return Math.max(left, right) + 1;
	}

	int diameter(Node root) {
		diameter = 0;
		findDiameter(root);
		return diameter;
	}

}
