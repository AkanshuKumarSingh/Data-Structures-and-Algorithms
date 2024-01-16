package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class _101_Cousins_of_given_node {
	// 1st way
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

	public static void find(Node root, Node block, int k, ArrayList<Integer> ans) {
		if (root == null)
			return;
		else if (root == block)
			return;
		if (k == 0) {
			ans.add(root.data);
			return;
		}

		find(root.left, block, k - 1, ans);
		find(root.right, block, k - 1, ans);
	}

	public static ArrayList<Integer> printCousins(Node root, Node node_to_find) {

		ArrayList<Node> path = nodeToRootPath(root, node_to_find.data);
		ArrayList<Integer> ans = new ArrayList<>();

		if (path.size() <= 2) {
			ans.add(-1);
			return ans;
		}
		for (int i = 2; i < path.size(); i++) {
			find(path.get(i), path.get(i - 1), i, ans);
		}
		if (ans.isEmpty())
			ans.add(-1);
		Collections.sort(ans);
		return ans;
	}

	// 2nd way
	static int k = 0;
	static int par = 0;

	public static void Level(Node root, int mylevel, int node, int parent) {
		if (root == null) {
			return;
		}
		if (root.data == node) {
			k = mylevel;
			par = parent;
			return;
		}
		Level(root.left, mylevel + 1, node, root.data);
		Level(root.right, mylevel + 1, node, root.data);
	}

	public static void Level1(Node root, int k, int par, int mylevel, int parent, ArrayList<Integer> l) {
		if (root == null) {
			return;
		}
		if (mylevel == k && parent != par) {
			l.add(root.data);
			return;
		}
		Level1(root.left, k, par, mylevel + 1, root.data, l);
		Level1(root.right, k, par, mylevel + 1, root.data, l);
	}

	public static ArrayList<Integer> printCousins1(Node root, Node n) {
		// code here
		Level(root, 1, n.data, -1);
		ArrayList<Integer> l = new ArrayList<>();
		Level1(root, k, par, 1, -1, l);
		if (l.size() == 0) {
			l.add(-1);
		}
		return l;
	}

}
