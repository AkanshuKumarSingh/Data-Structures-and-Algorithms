package BinaryTree;

public class _22_Determine_if_Two_Trees_are_Identical {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	boolean isIdentical(Node root1, Node root2) {
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		else if (root1 == null && root2 == null)
			return true;
		else if (root1.data != root2.data)
			return false;

		boolean identical = isIdentical(root1.left, root2.left);
		if (!identical)
			return false;

		identical = isIdentical(root1.right, root2.right);
		if (!identical)
			return false;

		return true;
	}

}
