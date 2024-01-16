package BinaryTree;

public class _35_Check_if_subtree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static boolean isSame(Node n, Node m) {
		if (n == null && m == null)
			return true;
		if (n == null || m == null)
			return false;
		else if (n.data != m.data)
			return false;
		return isSame(n.left, m.left) && isSame(n.right, m.right);
	}

	public static boolean isSubtree(Node T, Node S) {
		if (T == null)
			return false;

		if (isSame(T, S)) {
			return true;
		} else {
			if (isSubtree(T.left, S))
				return true;
			if (isSubtree(T.right, S))
				return true;
		}
		return false;
	}

}
