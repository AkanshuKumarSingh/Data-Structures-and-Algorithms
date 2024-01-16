package BinaryTree;

public class _59_Binary_Tree_to_CDLL {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static class TNode {
		Node head;
		Node tail;

		TNode(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	TNode convert(Node root) {
		if (root == null)
			return null;

		TNode left = convert(root.left);
		TNode right = convert(root.right);
		root.left = null;
		root.right = null;

		if (left != null && right != null) {
			left.tail.right = root;
			root.left = left.tail;
			root.right = right.head;
			right.head.left = root;
			return new TNode(left.head, right.tail);
		} else if (left != null) {
			left.tail.right = root;
			root.left = left.tail;
			return new TNode(left.head, root);
		} else if (right != null) {
			root.right = right.head;
			right.head.left = root;
			return new TNode(root, right.tail);
		} else {
			return new TNode(root, root);
		}

	}

	// Function to convert binary tree into circular doubly linked list.
	Node bTreeToClist(Node root) {
		TNode t = convert(root);
		t.head.left = t.tail;
		t.tail.right = t.head;
		return t.head;
	}

	
	// 2nd way
	Node prev = null;

	Node convert1(Node root) {
		if (root == null) {
			return null;
		}
		Node head = convert1(root.left);
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert(root.right);
		return head;
	}

	Node bTreeToClist1(Node root) {
//        System.out.println("HHM");
		Node head = convert1(root);
		head.left = prev;
		prev.right = head;
		return head;
	}

}
