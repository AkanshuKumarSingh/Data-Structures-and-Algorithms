package BinaryTree;

import java.util.ArrayList;

public class _41_Kth_Ancestor_in_Tree {

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// my approach
	public ArrayList<Integer> nodeToRootPath(Node root, int data) {
		if (root == null)
			return new ArrayList<Integer>();

		if (root.data == data) {
			ArrayList<Integer> cres = new ArrayList<Integer>();
			cres.add(data);
			return cres;
		}

		ArrayList<Integer> lres = nodeToRootPath(root.left, data);
		if (!lres.isEmpty()) {
			lres.add(root.data);
			return lres;
		}

		ArrayList<Integer> rres = nodeToRootPath(root.right, data);
		if (!rres.isEmpty()) {
			rres.add(root.data);
			return rres;
		}

		return new ArrayList<Integer>();
	}

	public int kthAncestor(Node root, int k, int node) {
		ArrayList<Integer> path = nodeToRootPath(root, node);
		if (path.size() <= k)
			return -1;
		return path.get(k);
	}

	// 2nd approach
	static int k = 1;

	// Program to find kth ancestor
	static boolean ancestor(Node root, int item) {
		if (root == null)
			return false;

		// Element whose ancestor is
		// to be searched
		if (root.data == item) {

			// Reduce count by 1
			k = k - 1;
			return true;
		} else {

			// Checking in left side
			boolean flag = ancestor(root.left, item);
			if (flag) {
				if (k == 0) {

					// If count = 0 i.e. element is found
					System.out.print(root.data + ", ");;
					return false;
				}

				// If count !=0 i.e. this is not the
				// ancestor we are searching for
				// so decrement count
				k = k - 1;
				return true;
			}

			// Similarly Checking in right side
			boolean flag2 = ancestor(root.right, item);
			if (flag2) {
				if (k == 0) {
					System.out.print(root.data + ", ");;
					return false;
				}
				k = k - 1;
				return true;
			}
		}
		return false;
	}

}
