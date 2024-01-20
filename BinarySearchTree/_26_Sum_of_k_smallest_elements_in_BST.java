package BinarySearchTree;

public class _26_Sum_of_k_smallest_elements_in_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int cnt = 0;

	int sum(Node root, int k) {
		if (root == null)
			return 0;
		int currSum = sum(root.left, k);
		cnt++;
		if (cnt <= k) {
			currSum += root.data;
		}

		if (cnt < k) {
			return sum(root.right, k) + currSum;
		}
		return currSum;
	}

}
