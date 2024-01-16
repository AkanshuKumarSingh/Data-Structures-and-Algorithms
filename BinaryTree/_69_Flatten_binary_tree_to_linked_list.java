package BinaryTree;

public class _69_Flatten_binary_tree_to_linked_list {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static class Pair {
		Node head, tail;

		Pair(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public static Pair flat(Node root) {
		if (root == null)
			return null;

		Pair p1 = flat(root.left);
		root.left = null;

		Pair p2 = flat(root.right);
		root.right = null;

		if (p1 == null && p2 == null) {
			return new Pair(root, root);
		} else if (p1 == null) {
			root.right = p2.head;
			return new Pair(root, p2.tail);
		} else if (p2 == null) {
			root.right = p1.head;
			return new Pair(root, p1.tail);
		}

		root.right = p1.head;
		p1.tail.right = p2.head;
		return new Pair(root, p2.tail);
	}

	public static void flatten(Node root) {
		flat(root);

	}

	// 2nd way
	static Node newNode(int key) {
		Node node = new Node(key);
		node.left = node.right = null;
		return node;
	}

	// Function to convert binary tree into linked list by
	// altering the right node and making left node point to
	// NULL
	static void flatten1(Node root) {
		// traverse till root is not NULL
		while (root != null) {
			// if root->left is not NULL
			if (root.left != null) {
				// set curr node as root->left;
				Node curr = root.left;
				// traverse to the extreme right of curr
				while (curr.right != null) {
					curr = curr.right;
				}
				// join curr->right to root->right
				curr.right = root.right;
				// put root->left to root->right
				root.right = root.left;
				// make root->left as NULL
				root.left = null;
			}
			// now go to the right of the root
			root = root.right;
		}
	}

}
