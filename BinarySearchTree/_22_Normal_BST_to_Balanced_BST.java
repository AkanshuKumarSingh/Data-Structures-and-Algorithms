package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class _22_Normal_BST_to_Balanced_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	List<Node> list = new ArrayList<>();

	void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		list.add(root);
		inorder(root.right);
	}

	Node makeTree(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node root = new Node(list.get(mid).data);
		root.left = makeTree(start, mid - 1);
		root.right = makeTree(mid + 1, end);
		return root;
	}

	Node buildBalancedTree(Node root) {
		// System.out.println("JSR");
		inorder(root);
		return makeTree(0, list.size() - 1);
	}

}
