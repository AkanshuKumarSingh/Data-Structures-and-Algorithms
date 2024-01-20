package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class _18_Binary_Tree_to_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	ArrayList<Integer> list = new ArrayList<>();

	void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.data);
		inorder(root.right);
	}

	Node makeBST(int st, int end) {
		if (st > end)
			return null;
		int mid = st + (end - st) / 2;
		Node node = new Node(list.get(mid));
		node.left = makeBST(st, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}

	Node binaryTreeToBST(Node root) {
		// System.out.println("JSR");
		inorder(root);
		Collections.sort(list);
		return makeBST(0, list.size() - 1);
	}

}
