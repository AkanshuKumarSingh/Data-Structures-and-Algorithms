package BinaryTree;

public class _67_Two_Mirror_Trees {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean areMirror(Node a, Node b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		if (a.data != b.data)
			return false;
		return areMirror(a.left, b.right) && areMirror(a.right, b.left);
	}

}
