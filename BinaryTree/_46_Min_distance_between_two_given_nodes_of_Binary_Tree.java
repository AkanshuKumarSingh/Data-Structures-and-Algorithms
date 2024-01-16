package BinaryTree;

import java.util.ArrayList;

public class _46_Min_distance_between_two_given_nodes_of_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static ArrayList<Node> nodeToRootPath(Node root, int data) {
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

	int findDist(Node node, int a, int b) {
		ArrayList<Node> path1 = nodeToRootPath(node, a);
		ArrayList<Node> path2 = nodeToRootPath(node, b);
		int i = path1.size() - 1, j = path2.size() - 1;
		while (i >= 0 && j >= 0) {
			if (path1.get(i) != path2.get(j))
				break;

			i--;
			j--;
		}

		return i + j + 2;
	}

}
