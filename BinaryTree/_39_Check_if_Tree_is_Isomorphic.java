package BinaryTree;

public class _39_Check_if_Tree_is_Isomorphic {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
				|| (isIsomorphic(root1.right, root2.left) && isIsomorphic(root1.left, root2.right));
	}

}
