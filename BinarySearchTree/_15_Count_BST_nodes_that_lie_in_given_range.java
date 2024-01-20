package BinarySearchTree;

public class _15_Count_BST_nodes_that_lie_in_given_range {
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

	int getCount(Node root, int l, int h) {
		if (root == null)
			return 0;
		int sum = 0;
		if (root.data < l) {
			sum += getCount(root.right, l, h);
		} else if (root.data > h) {
			sum += getCount(root.left, l, h);
		} else {
			sum += getCount(root.right, l, h);
			sum += getCount(root.left, l, h);
			sum++;
		}
		return sum;
	}

}
