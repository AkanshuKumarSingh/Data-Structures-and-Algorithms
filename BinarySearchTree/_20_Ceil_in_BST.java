package BinarySearchTree;

public class _20_Ceil_in_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int findCeil(Node root, int key) {
		if (root == null)
			return -1;
		if (root.data < key) {
			return findCeil(root.right, key);
		} else if (root.data > key) {
			int currAns = findCeil(root.left, key);
			if (currAns != -1)
				return currAns;
			return root.data;
		} else {
			return root.data;
		}
	}

}
