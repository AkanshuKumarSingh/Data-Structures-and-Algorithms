package BinaryTree;

public class _79_Leaves_to_DLL {

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

	Node head = null, tail = null;

	public Node removeLeaves(Node root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			if (head == null) {
				head = tail = root;
			} else {
				tail.right = root;
				root.left = tail;
				tail = root;
			}
			return null;
		}

		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}

	public Node convertToDLL(Node root) {
		removeLeaves(root);
		return head;
	}

}
