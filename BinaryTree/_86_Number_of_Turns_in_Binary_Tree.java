package BinaryTree;


public class _86_Number_of_Turns_in_Binary_Tree {

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

	static int turns = -1;

	static Node findLCA(Node root, int first, int second) {
		if (root == null) {
			return null;
		}
		return findLCAUtil(root, first, second);
	}

	static Node findLCAUtil(Node root, int n1, int n2) {
		// Base case
		if (root == null)
			return null;

		if (root.data == n1)
			return root;
		if (root.data == n2)
			return root;
		// Look for keys in left and right subtrees
		Node left_lca = findLCAUtil(root.left, n1, n2);
		Node right_lca = findLCAUtil(root.right, n1, n2);
		if (left_lca != null && right_lca != null) {
			return root;
		}
		return (left_lca != null) ? left_lca : right_lca;
	}

	static int ht(Node root, int first, int second, boolean isLeft) {
		if (root == null)
			return -1;
		if (root.data == first || root.data == second)
			return 0;
		int l = ht(root.left, first, second, true);
		int r = ht(root.right, first, second, false);
		// if(root.data == 1)
		// System.out.println(l + " " + r);
		if (l != -1 && r != -1) {
			turns = l + r + 1;
			return -1;
		} else if (l != -1) {
			if (isLeft)
				return l;
			else
				return l + 1;
		} else if (r != -1) {
			if (isLeft)
				return r + 1;
			else
				return r;
		} else {
			return -1;
		}

	}

	static int NumberOfTurns(Node root, int first, int second) {
		turns = -1;
		Node lca = findLCA(root, first, second);
		// System.out.println(n.data);
		if (lca == null)
			return turns;
		else if (lca.data == first) {
			turns = ht(lca, Integer.MAX_VALUE, second, true) - 1;
		} else if (lca.data == second) {
			turns = ht(lca, first, Integer.MAX_VALUE, true) - 1;
		} else {
			ht(lca, first, second, true);
		}
		return turns;
	}

}
