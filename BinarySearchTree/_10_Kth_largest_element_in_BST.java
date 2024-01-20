package BinarySearchTree;

public class _10_Kth_largest_element_in_BST {

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

	int cnt = 0;

	public int kthLargest(Node root, int K) {
		if (root == null)
			return -1;
		int no = kthLargest(root.right, K);
		if (no != -1)
			return no;
		cnt++;
		if (cnt == K)
			return root.data;
		return kthLargest(root.left, K);
	}

}
