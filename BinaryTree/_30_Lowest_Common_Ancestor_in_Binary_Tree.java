package BinaryTree;

import java.util.ArrayList;

public class _30_Lowest_Common_Ancestor_in_Binary_Tree {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public ArrayList<Node> nodeToRootPath(Node root, int data) {
		if (root == null)
			return new ArrayList<Node>();

		if (root.data == data) {
			ArrayList<Node> cres = new ArrayList<Node>();
			cres.add(root);
			return cres;
		}

		ArrayList<Node> lres = nodeToRootPath(root.left, data);
		if (!lres.isEmpty()) {
			lres.add(root);
			return lres;
		}

		ArrayList<Node> rres = nodeToRootPath(root.right, data);
		if (!rres.isEmpty()) {
			rres.add(root);
			return rres;
		}

		return new ArrayList<Node>();
	}

	// Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1, int n2) {
		ArrayList<Node> l1 = nodeToRootPath(root, n1);
		ArrayList<Node> l2 = nodeToRootPath(root, n2);

		int i = l1.size() - 1, j = l2.size() - 1;
		Node ans = null;
		while (i >= 0 && j >= 0) {
			if (l1.get(i) != l2.get(j))
				break;

			ans = l1.get(i);
			i--;
			j--;

		}

		return ans;
	}

}
