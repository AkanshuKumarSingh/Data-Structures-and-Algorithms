package BinaryTree;

public class _65_Check_if_two_Nodes_are_Cousins {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static class Pair {
		Node parent;
		int depth;

		Pair(Node parent, int depth) {
			this.parent = parent;
			this.depth = depth;
		}
	}

	public Pair parent(Node root, int data, int depth) {
		if (root == null)
			return null;
		if ((root.left != null && root.left.data == data) || (root.right != null && root.right.data == data)) {
			return new Pair(root, depth);
		}

		Pair ans = parent(root.left, data, depth + 1);
		if (ans != null)
			return ans;

		ans = parent(root.right, data, depth + 1);
		return ans;
	}

	public boolean isCousins(Node root, int a, int b) {
		Pair p1 = parent(root, a, 0), p2 = parent(root, b, 0);
		if (p1 == null || p2 == null)
			return false;
		if (p1.parent != p2.parent && p1.depth == p2.depth)
			return true;
		return false;
	}

}
